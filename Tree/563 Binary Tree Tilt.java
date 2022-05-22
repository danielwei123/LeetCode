// 563. Binary Tree Tilt

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
    public int findTilt(TreeNode root) {
        int[] res = new int[]{0};
        getSum(root, res);
        return res[0];
    }

    private int getSum(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            int right = getSum(root.right, arr);
            arr[0] += Math.abs(right);
            return root.val + right;
        } 
        if (root.right == null) {
            int left = getSum(root.left, arr);
            arr[0] += Math.abs(left);
            return root.val + left;
        } else {
            int left = getSum(root.left, arr);
            int right = getSum(root.right, arr);
            arr[0] += Math.abs(left - right);
            return root.val + left + right;
        }
    }
}