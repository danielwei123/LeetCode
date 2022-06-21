// 221. Maximal Square

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int maxLen = 0;
        
        // M[i][j] represents the length of the largest square containing only 1's 
        // with (i, j) is the right bottom corner
        int[][] M = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                M[i][0] = 1;
                maxLen = 1;
            } else {
                M[i][0] = 0;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                M[0][j] = 1;
                maxLen = 1;
            } else {
                M[0][j] = 0;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    M[i][j] = 0;
                } else {
                    int tmp = Math.min(M[i - 1][j], M[i][j - 1]);
                    tmp = Math.min(M[i - 1][j - 1], tmp);
                    M[i][j] = tmp + 1;
                }
                maxLen = Math.max(maxLen, M[i][j]);
            }
        }
        
        return maxLen * maxLen;
    }
}