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
    public boolean isBalanced(TreeNode root) {
        // If the helper returns -1, it means the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left child is already unbalanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right child is already unbalanced

        // Current node balance check
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height if balanced
        return Math.max(leftHeight, rightHeight) + 1;
    }
}