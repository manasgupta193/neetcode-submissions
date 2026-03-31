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
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2]; // [Robbed, Not Robbed]

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        // Case 1: Rob this node (Must NOT rob children)
        res[0] = root.val + left[1] + right[1];

        // Case 2: Do NOT rob this node (Can choose to rob or skip children)
        // We take the max of either choice for each child subtree
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}