// 106. Construct Binary Tree from Inorder and Postorder Traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return helper(inorder, postorder, inOrderIndexMap, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, Map<Integer, Integer> map, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postRight]);
        int rootIndex = map.get(postorder[postRight]);
        
        TreeNode left = helper(inorder, postorder, map, inLeft, rootIndex - 1, postLeft, postLeft + rootIndex - 1 - inLeft);
        TreeNode right = helper(inorder, postorder, map, rootIndex + 1, inRight, postLeft + rootIndex - inLeft, postRight - 1);
        
        root.left = left;
        root.right = right;
        return root;
    }
}