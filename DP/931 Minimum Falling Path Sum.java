// 931. Minimum Falling Path Sum

// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] pathSum = new int[n][n];
        for (int j = 0; j < n; j++) {
            pathSum[0][j] = matrix[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1 && j == 0) {
                    pathSum[i][j] = matrix[i][j] + pathSum[i - 1][j];
                } else if (j == 0) {
                    pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i - 1][j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i - 1][j - 1]) + matrix[i][j];
                } else {
                    pathSum[i][j] = Math.min(Math.min(pathSum[i - 1][j], pathSum[i - 1][j - 1]), pathSum[i - 1][j + 1]) + matrix[i][j];            
                }
            }
        }
        
        int res = pathSum[n - 1][0];
        for (int j = 1; j < n; j++) {
            res = Math.min(res, pathSum[n - 1][j]);
        }
        return res;
    }
}