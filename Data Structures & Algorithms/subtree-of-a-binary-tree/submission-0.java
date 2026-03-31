/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is empty, it can't contain a subtree
        if (root == null) return false;

        // 1. Check if the tree starting at 'root' is identical to 'subRoot'
        if (isSameTree(root, subRoot)) return true;

        // 2. If not, check the left and right children
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function from LC 100: Same Tree
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}