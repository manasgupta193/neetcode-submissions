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
    int preIdx = 0;
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map inorder values to their indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // The first element in current preorder range is the root
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        
        int inRootIdx = inMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = build(preorder, inStart, inRootIdx - 1);
        root.right = build(preorder, inRootIdx + 1, inEnd);

        return root;
    }
}