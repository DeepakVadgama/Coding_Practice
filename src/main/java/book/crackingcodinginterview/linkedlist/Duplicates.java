package book.crackingcodinginterview.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Remove all duplicates from linked list
 */
public class Duplicates {

    public static class LinkedList {

        private Node head;

        private class Node {
            int data;
            Node next;

            public Node(int i) {
                this.data = i;
            }
        }

        public void add(int i) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null)
                    curr = curr.next;
                curr.next = newNode;
            }
        }

        public void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }

        // With O(n) space complexity and O(N) time complexity
        public void removeDuplicates() {
            Set<Integer> set = new HashSet<>();
            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (set.contains(curr.data)) {
                    prev.next = curr.next;
                    curr = prev.next;
                } else {
                    set.add(curr.data);
                    prev = prev.next;
                    curr = prev.next;
                }

            }
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        list.removeDuplicates();
        list.print();
    }
}
