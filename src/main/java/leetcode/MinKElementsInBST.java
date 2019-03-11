package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinKElementsInBST {

    public static void main(String[] args) {

    }

    public int KthSmallest(TreeNode root, int k) {

        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.offerFirst(node);
                node = node.left;
            }

            node = stack.pollFirst();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
