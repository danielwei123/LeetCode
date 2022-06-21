// 45. Jump Game II

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        // M[i] represents the minimum number of jumps to reach nums[i]
        int[] M = new int[nums.length];
        M[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    curMin = Math.min(curMin, M[j] + 1);
                }
            }
            M[i] = curMin;
        }
        return M[nums.length - 1];
    }
}