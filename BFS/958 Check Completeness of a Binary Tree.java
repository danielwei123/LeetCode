// 958. Check Completeness of a Binary Tree

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
    public boolean isCompleteTree(TreeNode root) {
        // Use BFS to check layer by layer
        // Once a bubble is found, no further values can be found
        Queue<TreeNode> q = new LinkedList<TreeNode> ();
        if (root == null) {
            return true;
        }
        
        boolean isComplete = true;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;

                if (cur.left == null && cur.right == null) {
                    isComplete = false;
                } else if (cur.left == null) {
                    return false;
                } else if (cur.right == null) {
                    if (!isComplete) return false;
                    isComplete = false;
                } else {
                    if (!isComplete) return false;
                }
                
                q.offer(cur.left);
                q.offer(cur.right);

            }            
        }
        
        return true;
    }
}