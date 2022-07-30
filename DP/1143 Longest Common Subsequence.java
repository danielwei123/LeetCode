// 1143. Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      // int[i][j] records the length of the longest common subsequence of text1.substring(0, i+1) and text2.substring(0, j+1) 
      int[][] commonLen = new int[text1.length()][text2.length()];
      for (int i = 0; i < text1.length(); i++) {
        for (int j = 0; j < text2.length(); j++) {
          if (i == 0 && j == 0) {
            commonLen[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
          } else if (i == 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
              commonLen[i][j] = 1;
            } else {
              commonLen[i][j] = commonLen[i][j - 1];
            }
          } else if (j == 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
              commonLen[i][j] = 1;
            } else {
              commonLen[i][j] = commonLen[i - 1][j];
            }
          } else {
            if (text1.charAt(i) == text2.charAt(j)) {
              commonLen[i][j] = commonLen[i - 1][j - 1] + 1;
            } else {
              commonLen[i][j] = Math.max(commonLen[i - 1][j], commonLen[i][j - 1]);
            }
          }
        }
      }
      
      return commonLen[text1.length() - 1][text2.length() - 1];
    }
}