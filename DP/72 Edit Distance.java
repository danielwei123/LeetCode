// 72. Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {
        // distance[i][j] represents the edited distance between substring(0,i) in word1 and substring(0,j) in word2
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i  = 0; i <= word1.length(); i++) {
          for (int j = 0; j <= word2.length(); j++) {
            if (i == 0) {
              distance[i][j] = j;
            } else if (j == 0) {
              distance[i][j] = i ;
            } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
              distance[i][j] = distance[i - 1][j - 1];
            } else {
              // Insert, Delete
              distance[i][j] = Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1);
              // Replace
              distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i][j]);
            }
          }
        }
        return distance[word1.length()][word2.length()];
    }
}