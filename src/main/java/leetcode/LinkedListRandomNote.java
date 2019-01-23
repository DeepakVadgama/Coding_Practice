package leetcode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class LinkedListRandomNote {

    private final ListNode head;
    private Random random = new Random();

    public LinkedListRandomNote(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int count = 0;
        ListNode curr = head;
        ListNode random = head;
        while (curr.next != null) {
            curr = curr.next;
            count++;
            if (getRandom(count) == count) {
                random = curr;
            }
        }
        return random.val;
    }

    private int getRandom(int count) {
        return random.nextInt(count + 1);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
