package leetcode;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOneLinkedList {

    public static void main(String[] args) {
        PlusOneLinkedList list = new PlusOneLinkedList();
        ListNode node = list.createList(9, 9, 9);
        list.printList(node);
        ListNode incremented = list.plusOne(node);
        list.printList(incremented);
    }

    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        increment(head);
        head = reverse(head);
        return head;
    }

    private void increment(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            if (curr.val + 1 > 9) {
                curr.val = 0;
            } else {
                curr.val++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = new ListNode(1);
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode createList(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public void printList(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value) {
            this.val = value;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
