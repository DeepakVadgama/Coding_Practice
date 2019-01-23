package book.crackingcodinginterview.linkedlist;

import java.util.Scanner;

/**
 * Check if LinkedList is palindrome (O(1) space, and O(N) time).
 */
public class Palindrome {

    private static Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int i) {
            this.data = i;
        }
    }

    public static void add(int i) {
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

    public static void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            add(in.nextInt());
        }

        Node middle = findMiddle(head);
        Node headOfList2 = disconnect(middle);
        headOfList2 = reverse(headOfList2);
        boolean isSame = compare(head, headOfList2);

        System.out.println(isSame ? "Palindrome" : "Not Palindrome");
    }

    private static boolean compare(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return true;
    }

    private static Node reverse(Node head) {
        Node current = head;
        Node previous = null;

        while (current.next != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        current.next = previous;
        return current;
    }

    private static Node disconnect(Node middle) {
        Node temp = middle.next;
        middle.next = null;
        return temp;
    }

    private static Node findMiddle(Node head) {
        Node current = head;
        Node jumper = head;
        while (jumper.next != null && jumper.next.next != null) {
            current = current.next;
            jumper = jumper.next.next;
        }
        return current;
    }
}
