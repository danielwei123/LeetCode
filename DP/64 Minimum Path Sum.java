// 64. Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathSum = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                pathSum[i][0] = grid[0][0];
                for (int j = 1; j < n; j++) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j];
                }
            } else {
                pathSum[i][0] = pathSum[i - 1][0] + grid[i][0];
                for (int j = 1; j < n; j++) {
                    pathSum[i][j] = Math.min(pathSum[i][j - 1], pathSum[i - 1][j]) + grid[i][j];
                }
            }
        }
        
        return pathSum[m - 1][n - 1];
    }
}