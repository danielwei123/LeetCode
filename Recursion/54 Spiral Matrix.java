// 122 Spiral Order Traverse II

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<Integer>();
    int size = Math.min(matrix.length, matrix[0].length);
    traverse(matrix, size, 0, result);
    return result;
  }

  private void traverse(int[][] mat, int size, int offset, List<Integer> result) {
    if (size <= 0) {
      return;
    }
    if (size == 1) {
      if (mat[0].length > mat.length) {
        for (int i = offset; i < mat[0].length - offset; i++) {
          result.add(mat[offset][i]);
        }
      } else {
        for (int i = offset; i < mat.length - offset; i++) {
          result.add(mat[i][mat[0].length - offset - 1]);
        }
      }
      return;
    }

    for (int i = offset; i < mat[0].length - offset - 1; i++) {
      result.add(mat[offset][i]);
    }
    for (int i = offset; i < mat.length - offset - 1; i++) {
      result.add(mat[i][mat[0].length - offset - 1]);
    }
    for (int i = offset; i < mat[0].length - offset - 1; i++) {
      result.add(mat[mat.length - offset - 1][mat[0].length - 1 - i]);
    }
    for (int i = offset; i < mat.length - offset - 1; i++) {
      result.add(mat[mat.length - 1 - i][offset]);
    }

    traverse(mat, size - 2, offset + 1, result);
    
    return;
  }
}
