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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainFromSubtree(root);
        return maxSum;
    }

    private int gainFromSubtree(TreeNode node) {
        if (node == null) return 0;

        // Recursive call to get the max gain from left and right subtrees
        // We use Math.max(..., 0) to ignore paths that would decrease our sum
        int leftGain = Math.max(gainFromSubtree(node.left), 0);
        int rightGain = Math.max(gainFromSubtree(node.right), 0);

        // This node acts as the "Highest Point" (Peak) of a path
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum seen so far
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain this node can contribute to its parent's path
        // A parent can only take ONE branch (left or right)
        return node.val + Math.max(leftGain, rightGain);
    }
}
