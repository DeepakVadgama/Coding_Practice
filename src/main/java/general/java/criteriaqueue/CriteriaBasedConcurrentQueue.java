package general.java.criteriaqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class is implements a thread safe bounded queue with
 * fairness policy (items are served first come first server basis)
 * The requests for elements can be based on criteria around Strings
 * <p>
 * The element class <E> needs to implement Criteria interface to
 * enable correct storage and retrieval of items.
 */
public class CriteriaBasedConcurrentQueue<E extends Criteria> {

    // Bounded queue
    private final int size;

    // Map of criteria and element-list key/value pair
    // Dev note: This could be done in single list but quickly becomes complicated. 
    private final Map<String, List<E>> items = new HashMap<>();

    // Map of criteria and request queue key/value pair
    private final Map<String, List<Object>> requests = new HashMap<>();

    public CriteriaBasedConcurrentQueue(int size) {
        this.size = size;
    }

    // Add element
    public void put(E e) {

        final String criteria = e.getCriteria();

        // If no element queue created yet, create one
        createElementQueueIfNotPresent(criteria);

        // Add element and notify waiting consumer, if any 
        final List<E> elementQueue = items.get(criteria);
        synchronized (elementQueue) {

            // Wait if queue full
            while (elementQueue.size() == size) {
                try {
                    System.out.println("Queue full for " + criteria + ". Waiting.. ");
                    elementQueue.wait();
                } catch (InterruptedException e1) {
                    System.err.println("Excepting waiting for queue to be empty");
                }
            }

            elementQueue.add(e);
        }

        // If any requests waiting, notify first one.
        if (requests.containsKey(criteria)) {
            final List<Object> requestQueue = requests.get(criteria);
            synchronized (requestQueue) {
                if (requestQueue.size() > 0) {
                    // Notify first request of the queue (FIFO)
                    synchronized (requestQueue.get(0)) {
                        requestQueue.get(0).notify();
                    }
                }
            }
        }
    }


    // Request for get element
    public E get(String criteria) {

        createRequestQueueIfNotPresent(criteria);
        createElementQueueIfNotPresent(criteria); // In case consumer is called before producer.

        // If there are no waiting requests and elements are present, get element and return.
        final Object lock;
        final List<Object> requestQueue = requests.get(criteria);
        synchronized (requestQueue) {
            if (requestQueue.size() == 0) { // No pending request
                final List<E> elementQueue = items.get(criteria);
                synchronized (elementQueue) {
                    if (elementQueue.size() > 0) {  // Elements present
                        final E element = elementQueue.remove(0);
                        elementQueue.notifyAll();  // Notify any producers waiting for queue to be non-full
                        return element;
                    }
                }
            }

            // Otherwise, add request to queue
            lock = new Object();
            requestQueue.add(lock);
        }

        try {
            // Wait for producer to notify
            // Dev note: Used lock object instead of this, to avoid http://stackoverflow.com/a/14187095/3494368
            synchronized (lock) {
                lock.wait();
            }

            // Get element and notify any producers waiting for queue to be non-full
            final E element;
            final List<E> elementQueue = items.get(criteria);
            synchronized (elementQueue) {
                element = elementQueue.remove(0);
                elementQueue.notifyAll();
            }

            // Request competed. Ok to remove from queue.
            synchronized (requestQueue) {
                requestQueue.remove(0);
            }
            return element;

        } catch (InterruptedException e) {
            System.err.println("Error in consumer wait");
            return null;
        }
    }

    private void createElementQueueIfNotPresent(String criteria) {
        if (!items.containsKey(criteria)) {
            synchronized (items) {
                if (!items.containsKey(criteria)) { // double check

                    // Dev note: LinkedList better than ArrayList for perf (remove method), 
                    // but beware size() should be called within synchronized, otherwise can return incorrect results.
                    items.put(criteria, new LinkedList<>());
                }
            }
        }
    }

    private void createRequestQueueIfNotPresent(String criteria) {
        if (!requests.containsKey(criteria)) {
            synchronized (requests) {
                if (!requests.containsKey(criteria)) { // double check

                    // Dev note: LinkedList better than ArrayList for perf (remove method), 
                    // but beware size() should be called within synchronized, otherwise can return incorrect results. 
                    requests.put(criteria, new LinkedList<>());
                }
            }
        }
    }
}
