// 107. Binary Tree Level Order Traversal II

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<List<Integer>> resQueue = new ArrayDeque<>();
        
        if (root == null) {
            return res;
        }
        
        q.offerFirst(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = q.pollLast();
                tmp.add(cur.val);
                if (cur.left != null) {
                    q.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    q.offerFirst(cur.right);
                }
                size--;
            }
            resQueue.offerFirst(tmp);
        }
        
        while (!resQueue.isEmpty()) {
            res.add(resQueue.pollFirst());
        }
        
        return res;
    }
}