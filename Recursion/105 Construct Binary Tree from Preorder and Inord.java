// 105. Construct Binary Tree from Preorder and Inorder Traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {       
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pLeft]);
        
        int rootIndexOfInOrder = iLeft;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == preorder[pLeft]) {
                rootIndexOfInOrder = i;
            }
        }
        
        TreeNode left = helper(preorder, inorder, pLeft + 1, pLeft + rootIndexOfInOrder - iLeft, iLeft, rootIndexOfInOrder - 1);
        TreeNode right = helper(preorder, inorder, pLeft + rootIndexOfInOrder - iLeft + 1, pRight, rootIndexOfInOrder + 1, iRight);
        
        root.left = left;
        root.right = right;
        
        return root;        
    }
    
}