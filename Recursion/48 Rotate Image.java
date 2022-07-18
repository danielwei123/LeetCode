// 48. Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        helper(matrix, 0, n);
        return;
    }
    
    private void helper(int[][] matrix, int offset, int len) {
        if (len == 0 || len == 1) return;
        for (int i = 0; i < len - 1; i++) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + len - i - 1][offset];
            matrix[offset + len - i - 1][offset] = matrix[offset + len - 1][offset + len - i - 1];
            matrix[offset + len - 1][offset + len - i - 1] = matrix[offset + i][offset + len - 1];
            matrix[offset + i][offset + len - 1] = temp;
        }
        helper(matrix, offset + 1, len - 2);
    }
}