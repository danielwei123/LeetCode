// 437. Path Sum III

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

// Solution 1: Bottom up
class Solution {
    int[] res = new int[]{0};
    public int pathSum(TreeNode root, int targetSum) {
        
        if (root == null) {
            return res[0];
        }
        helper(root, res, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res[0];
    }
    
    // find all paths that starting from current Node and meet requirement
    private void helper(TreeNode root, int[] res, int target) {
        if (root == null) {
            return;
        }
        
        if (root.val == target) {
            res[0] += 1;
        }
        
        helper(root.left, res, target - root.val);
        helper(root.right, res, target - root.val);
        return;
    }
}

// Solution 2: Top down
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> arr = new ArrayList<Integer>();
        int[] res = new int[]{0};
        DFS(root, targetSum, arr, res);
        return res[0];
    }

    // find path where ends at current root node and path sum equals targetSum
    private void DFS(TreeNode root, int targetSum, List<Integer> arr, int[] res) {
        if (root == null) return;
        
        long sum = 0;
        arr.add(root.val);

        for (int i = arr.size() - 1; i >= 0; i--) {
            sum += arr.get(i);
            if (sum == targetSum) {
                res[0]++;
            }
        }

        DFS(root.left, targetSum, arr, res);
        DFS(root.right, targetSum, arr, res);
        arr.remove(arr.size() - 1);
    }
}