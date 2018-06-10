package teaching.reactive;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _1 {

    public static void main(String[] args) {

        _1 object = new _1();
        object.printDBValue();
    }

    private void printDBValue() {

        ExecutorService service = Executors.newFixedThreadPool(5);

        Task task = new Task();
        service.submit(task);
    }

    private class Task implements Callable<String> {

        @Override
        public String call() {

            // fetch from DB
            return "fetched-value";
        }
    }
}
