// 257. Binary Tree Paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();    
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            helper(root, sb, res);
        }
        return res;
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
        int length = sb.length();
        if (root.left == null && root.right == null) {
            res.add(sb.append(root.val).toString());
        } else if (root.left == null) {
            sb.append(root.val);
            sb.append("->");
            helper(root.right, sb, res);
        } else if (root.right == null) {
            sb.append(root.val);
            sb.append("->");
            helper(root.left, sb, res);
        } else {
            sb.append(root.val);
            sb.append("->");
            helper(root.left, sb, res);
            helper(root.right, sb, res);
        }
        sb.setLength(length);
        return;
    }
}