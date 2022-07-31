// 486. Predict the Winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {       
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
          prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
      
      
        int sum1 = getMaxSum(nums, prefixSum);
        int sum2 = prefixSum[prefixSum.length - 1] - sum1;
        return sum1 >= sum2;
    }

    // Solution 1: DP
    public int getMaxSum(int[] nums, int[] prefixSum) {
      // Write your solution here
      // getMax[i][j] stores the max value you will get if you pick first from index i to j
      int[][] getMax = new int[nums.length][nums.length];
      for (int i = 0; i < nums.length; i++) {
        getMax[i][i] = nums[i];
      }
      for (int i = 0; i < nums.length - 1; i++) {
        getMax[i][i + 1] = Math.max(nums[i], nums[i + 1]);
      }
      // len = right - left
      for (int len = 2; len < nums.length; len++) {
        for (int i = 0; i + len < nums.length; i++) {
          int totalSum = prefixSum[i + len + 1] - prefixSum[i];
          // I pick left
          int sumPickLeft = totalSum - getMax[i + 1][i + len];
          // I pick right
          int sumPickRight = totalSum - getMax[i][i + len - 1];
          getMax[i][i + len] = Math.max(sumPickLeft, sumPickRight);
        }
      }

      return getMax[0][nums.length - 1];
    }

    // Solution 2: Recursion

      // private int helper(int[] arr, int left, int right) {
      //   if (left > right) {
      //     return 0;
      //   }
      //   if (left == right) {
      //     return arr[left];
      //   }
      //   if (left == right - 1) {
      //     return Math.max(arr[left], arr[right]);
      //   }

      //   // I pick left
      //   int maxLeft = 0;
      //   if (arr[left + 1] <= arr[right]) {
      //     maxLeft = arr[left] + helper(arr, left + 1, right - 1);
      //   } else {
      //     maxLeft = arr[left] + helper(arr, left + 2, right);
      //   }
      //   // I pick right
      //   int maxRight = 0;
      //   if (arr[left] <= arr[right - 1]) {
      //     maxRight = arr[right] + helper(arr, left, right - 2);
      //   } else {
      //     maxRight = arr[right] + helper(arr, left + 1, right - 1);
      //   }
      //   return Math.max(maxLeft, maxRight);
      // }
}