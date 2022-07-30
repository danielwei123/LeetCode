// 300. Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
      int length = nums.length;  
      // seqLen[i] means the length of the longest increasing subsequence end at nums[i]
      int[] seqLen = new int[length];
      int max = 1;
      seqLen[0] = 1;
      
      for (int i = 1; i < length; i++) {
        int curMax = 1;
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) {
            curMax = Math.max(curMax, seqLen[j] + 1);
          }
        }
        seqLen[i] = curMax;
        max = Math.max(max, curMax);
      }
      
      return max;
    }
}