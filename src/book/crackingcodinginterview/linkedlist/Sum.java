package book.crackingcodinginterview.linkedlist;

import java.util.Scanner;

/**
 * Add 2 linkedlist of numbers. The list is given in reverse order.
 * <p>
 * Eg:
 * 7 -> 1 -> 6 (617)
 * 5 -> 9 -> 2 (295)
 * Sum = 2 -> 1 -> 9 (912)
 * <p>
 * (If lists are in forward order its easier to reverse and add
 * due to carry overs and singly linked list)
 */
public class Sum {

    public static class LinkedList {

        private Node head;

        private class Node {
            int data;
            Node next;

            public Node(int i) {
                this.data = i;
            }
        }

        public Node head() {
            return head;
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
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        LinkedList l1 = getList(in, n1);
        LinkedList l2 = getList(in, n2);

        LinkedList l3 = new LinkedList();
        LinkedList.Node c1 = l1.head();
        LinkedList.Node c2 = l2.head();

        int carry = 0;
        while (c1 != null || c2 != null) {

            int v1 = c1 != null ? c1.data : 0;
            int v2 = c2 != null ? c2.data : 0;
            int val = v1 + v2 + carry;
            l3.add(val % 10);
            carry = val / 10;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }
        if (carry > 0) {
            l3.add(carry);
        }

        l3.print();
    }

    private static LinkedList getList(Scanner in, int n) {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            list1.add(in.nextInt());
        }
        return list1;
    }
}
