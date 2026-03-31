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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 1. Find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 2. We found the node! Handle the 3 cases:
            
            // Case 1 & 2: Leaf or One Child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two Children
            // Find the Inorder Successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);
            // Replace current value with successor's value
            root.val = successor.val;
            // Delete the successor from the right subtree
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}