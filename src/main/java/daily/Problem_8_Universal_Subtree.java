package daily;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * <p>
 * Given the root to a binary tree, count the number of unival subtrees.
 * <p>
 * For example, the following tree has 5 unival subtrees:
 * <p>
 * <p>
 * 0
 * / \
 * 1   0
 * / \
 * 1   0
 * /\
 * 1  1
 */
public class Problem_8_Universal_Subtree {

    public static void main(String[] args) {

        isUnival(getTree());
        System.out.println(count);
    }

    public static int count = 0;

    private static boolean isUnival(Node node) {

        if (node == null) {
            return false;
        }

        if (isLeaf(node)) {
            count++;
            return true;
        }

        boolean leftUnival = isUnival(node.left);
        boolean rightUnival = isUnival(node.right);
        if (leftUnival && rightUnival
                && node.left.data == node.data
                && node.right.data == node.data) {
            count++;
            return true;
        }
        return false;
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private static Node getTree() {
        Node ones = new Node(1, new Node(1), new Node(1));
        Node newRoot = new Node(0, ones, new Node(0));
        Node root = new Node(0, new Node(1), newRoot);
        return root;
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
