// 543. Diameter of Binary Tree

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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }
        maxHeight(root);
        return res;
    }
    
    // Get the max height of the tree where current Node is root Node
    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}