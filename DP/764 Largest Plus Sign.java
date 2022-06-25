// 764. Largest Plus Sign

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // DP

        // create a matrix with all 1s
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        }
        
        // change matrix values to 0 based on mines[][]
        for (int index = 0; index < mines.length; index++) {
            matrix[mines[index][0]][mines[index][1]] = 0;
        }
        
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            left[i][0] = matrix[i][0];
            right[i][n - 1] = matrix[i][n - 1];
            for (int j = 1; j < n; j++) {
                left[i][j] = matrix[i][j] == 0 ? 0 : left[i][j - 1] + 1;
                right[i][n - 1 - j] = matrix[i][n - 1 - j] == 0 ? 0 : right[i][n - j] + 1;
            }
        }
        
        for (int j = 0; j < n; j++) {
            top[0][j] = matrix[0][j];
            bottom[n - 1][j] = matrix[n - 1][j];
            for (int i = 1; i < n; i++) {
                top[i][j] = matrix[i][j] == 0 ? 0 : top[i - 1][j] + 1;
                bottom[n - 1 - i][j] = matrix[n - 1 - i][j] == 0 ? 0 : bottom[n - i][j] + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min1 = Math.min(top[i][j], bottom[i][j]);
                int min2 = Math.min(left[i][j], right[i][j]);
                int min3 = Math.min(min1, min2);
                maxLen = Math.max(maxLen, min3);
            }
        }
        
        return maxLen;
    }
}