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
    Set<String> rootHashes = new HashSet<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        serialize(root, true);
        String targetHash = serialize(subRoot, false);
        return rootHashes.contains(targetHash);
    }

    private String serialize(TreeNode node, boolean store) {
        if (node == null) return "#";
        
        // Create a unique representation of the subtree
        String hash = "(" + node.val + serialize(node.left, store) + serialize(node.right, store) + ")";
        
        if (store) rootHashes.add(hash);
        return hash;
    }
}