// 226. Invert Binary Tree

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
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
          return root;
        }

        if (root.left == null) {
          root.left = root.right;
          invertTree(root.left);
          root.right = null;
        } else if (root.right == null) {
          root.right = root.left;
          invertTree(root.right);
          root.left = null;
        } else {
          TreeNode tmp = root.left;
          root.left = root.right;
          root.right = tmp;
          invertTree(root.left);
          invertTree(root.right);
        }
        return root;
    }
}