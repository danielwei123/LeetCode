// 124. Binary Tree Maximum Path Sum

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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, res);
        return res[0];
    }
    
    private int maxPathSumHelper(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        
        int left = maxPathSumHelper(root.left, arr);
        int right = maxPathSumHelper(root.right, arr);
        
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        
        arr[0] = Math.max(root.val + left + right, arr[0]);
        
        return Math.max(root.val + left, root.val + right);
    }
}