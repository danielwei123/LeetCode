// 85. Maximal Rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] verticalSum = new int[m][n];
        for (int j = 0; j < n; j++) {
            verticalSum[0][j] = matrix[0][j] == '1' ? 1 : 0;
            for (int i = 1; i < m; i++) {
                verticalSum[i][j] = matrix[i][j] == '1' ? 1 + verticalSum[i - 1][j]: 0;
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {            
            res = Math.max(res, getMaxSum(verticalSum[i]));
        }
        return res;
    }
    
    // Leetcode 84
    private int getMaxSum(int[] arr) {
        // store index of the array
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int maxSum = 0;
        for (int i = 0; i <= arr.length; i++) {
            int curHeight = i == arr.length ? 0 : arr[i];
            while (!dq.isEmpty() && arr[dq.peekFirst()] > curHeight) {
                int index = dq.pollFirst();
                int height = arr[index];
                int left = dq.isEmpty() ? 0 : dq.peekFirst() + 1;
                int width = i - left;
                maxSum = Math.max(maxSum, height * width);
            }
            if (i < arr.length) {
                dq.offerFirst(i);
            }
        }
        return maxSum;
    }
}