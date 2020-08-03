class PathSum_118 {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        pathToSumRecurse(root, sum, 0, currentPath, result);

        return result;
    }

    private void pathToSumRecurse(TreeNode node, 
                                    int sum, 
                                    int currentSum,
                                    List<Integer> currentPath, 
                                    List<List<Integer>> result){

        if(node == null){
            return;
        }

        currentPath.add(node.val);
        currentSum += node.val;

        if(currentSum == sum && isLeaf(node)){
            result.add(List.copyOf(currentPath));
        }

        pathToSumRecurse(node.left, sum, currentSum, currentPath, result);
        pathToSumRecurse(node.right, sum, currentSum, currentPath, result);

        currentSum -= node.val;
        currentPath.remove(currentPath.size()-1);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}
