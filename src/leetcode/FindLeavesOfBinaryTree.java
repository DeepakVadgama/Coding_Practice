package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree
 */
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<Integer, List<Integer>> leavesPerDepth = new HashMap<>();
        dfs(root, leavesPerDepth);
    }

    private int dfs(TreeNode node, HashMap<Integer, List<Integer>> leavesMap) {
        if (node == null) return 0;
        int height = Math.max(dfs(node.left, leavesMap), dfs(node.right, leavesMap));
        leavesMap.computeIfAbsent(height, k -> new ArrayList<>()).add(node.data);
        return height + 1;
    }

    private class TreeNode {
        int data;
        TreeNode left, right;
    }
}
