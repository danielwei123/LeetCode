// 1547. Minimum Cost to Cut a Stick

class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        // First pad original array at leftmost and rightmost
        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        helper[helper.length - 1] = n;
        for (int i = 1; i < helper.length - 1; i++) {
          helper[i] = cuts[i - 1];
        }

        // minCost[i][j]: the min cost of cutting the partition (i. j)
        int[][] minCost = new int[helper.length][helper.length];
        for (int i = 1; i < helper.length; i++) {
          for (int j = i - 1; j >= 0; j--) {
            if (j == i - 1) {
              minCost[j][i] = 0;
            } else {
              minCost[j][i] = Integer.MAX_VALUE;
              for (int k = j + 1; k <= i - 1; k++) {
                minCost[j][i] = Math.min(minCost[j][i], helper[i] - helper[j] + minCost[j][k] + minCost[k][i]);
              }
            }
          }
        }

        return minCost[0][helper.length - 1];
      
    }
}