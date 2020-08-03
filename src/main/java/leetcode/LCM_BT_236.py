def lowestCommonAncestor(self, root, p, q):
				# If looking for me, return myself
        if root == p or root == q:
            return root
        
        left = right = None
        # else look in left and right child
        if root.left:
            left = self.lowestCommonAncestor(root.left, p, q)
        if root.right:
            right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        else:
            return left or right
