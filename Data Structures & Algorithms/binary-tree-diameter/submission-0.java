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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Recursive bottom-up height calculation
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // Update the global diameter tracker
        // Diameter at this node is left path + right path
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of this subtree to the parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
