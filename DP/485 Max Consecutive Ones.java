// 485. Max Consecutive Ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {       
        int last = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                last = 0;
            } else {
                last += 1;
                max = Math.max(max, last);
            }
        }
        
        return max;
    }
}