package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */
public class Problem_3_Serialize_Tree {

    public static void main(String[] args) {

        Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        String output = serialize(node);
        System.out.println(output);

        Node root = deserialize(output);
        System.out.println();
    }

    private static Node deserialize(String output) {

        String[] nodes = output.split(" ");

        Node root = new Node(nodes[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;
        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current == DUMMY) {
                continue;
            }

            current.left = nodes[idx].equals("_") ? DUMMY : new Node(nodes[idx]);
            queue.add(current.left);
            idx++;

            current.right = nodes[idx].equals("_") ? DUMMY : new Node(nodes[idx]);
            queue.add(current.right);
            idx++;
        }

        return root;
    }

    // bfs
    private static String serialize(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder output = new StringBuilder();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            output.append(current.data).append(" ");
            if (current != DUMMY) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return output.toString();
    }

    static final Node DUMMY = new Node("_");

    private static class Node {

        public Node left;
        public Node right;
        public String data;

        public Node(String data) {
            this.data = data;
            this.right = DUMMY;
            this.left = DUMMY;
        }

        public Node(String data, Node left, Node right) {
            this.left = left == null ? DUMMY : left;
            this.right = right == null ? DUMMY : right;
            this.data = data;
        }

        public Node() {
        }
    }


}
