// 209. Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      
      // Use two pointers
      int fast = 0;
      int sum = 0;
      int ans = Integer.MAX_VALUE;
      
      for (int slow = 0; slow < nums.length; slow++) {
        while (sum < target && fast < nums.length) {
          sum += nums[fast++];
        }

        if (sum >= target) {
          ans = Math.min(ans, fast - slow);
        }
        
        sum -= nums[slow];
        
      }
      
      if (ans == Integer.MAX_VALUE) {
        return 0;
      }
      
      return ans;
    }
}