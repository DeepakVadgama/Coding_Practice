package leetcode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return visit(root);
    }

    private int visit(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int temp = 0;
            if (hasLeftLeaf(node)) {
                temp = node.left.val;
            }
            int left = visit(node.left);
            int right = visit(node.right);
            return left + right + temp;
        }
    }

    private boolean hasLeftLeaf(TreeNode node) {
        return node != null
                && node.left != null
                && node.left.left == null
                && node.left.right == null;
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
