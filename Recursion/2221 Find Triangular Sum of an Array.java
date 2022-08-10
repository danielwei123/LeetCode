// 2221. Find Triangular Sum of an Array

class Solution {
    // Pascal Triangle Problem
    
    // Solution 1: Recursion
    // TC: O(n^2)
    // SC: O(n)
    public int triangularSum(int[] nums) {
        int n = nums.length;
        helper(nums, n);
        return nums[0];
    }
    
    private void helper(int[] nums, int n) {
        if (n == 1) return;
        for (int i = 0; i < n - 1; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        helper(nums, n - 1);
    }

//     // Solution 2: Math
//     public int triangularSum(int[] nums) {
//         int sum = 0;
//         for (int i = 0; i< nums.length; i++) {
//             sum += nums[i] * getCombniation()
//         }        
//     }
    
//     private int getCombniation(int n, int k) {
        
//     }

  
}