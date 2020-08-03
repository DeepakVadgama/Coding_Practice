class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
    if(root == null && sum == 0) {
		return false;
	}

    if(sum == 0) {
		return true;
	}

	if(root == null) {
		return false;
	}

	int remaining = sum - root.val;
	return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);

    }
}
