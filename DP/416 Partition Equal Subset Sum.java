// 416. Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) {
          sum += n;
        }
        if (sum % 2 == 1) {
          return false;
        }
      
        // 0-1 Knapsack problem
        // M[i][W]: whether total sum of W can be achieved with the first i elements
        boolean[][] M = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            M[i][0] = true;
            for (int j = 1; j <= sum / 2; j++) {
                if (i == 0) {
                    M[i][j] = false;
                } else if (j - nums[i - 1] < 0) {
                    M[i][j] = M[i - 1][j];
                } else {
                    M[i][j] = M[i - 1][j] || M[i - 1][j - nums[i - 1]];
                }
            }
            if (M[i][sum / 2]) {
                return true;
            }
        }
        return false;
    }
}