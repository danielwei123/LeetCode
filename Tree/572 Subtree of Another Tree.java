// 572. Subtree of Another Tree

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
    // Go through each node of root Tree to see if identical tree occurs
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return isIdentical(root, subRoot);
        }
        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Check if two trees are identical
    private boolean isIdentical(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null){
            return false;
        } else if (n1.val != n2.val) {
            return false;
        } else {
            return isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
        }
    }
}