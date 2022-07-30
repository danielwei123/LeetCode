// 683. Count Ascending Subsequence

public class Solution {
  public int numIncreasingSubsequences(int[] a) {
    // Write your solution here
    // res[i] means the number of ascending subsequences ending at index i
    if (a == null || a.length == 0) return 0;
    int[] res = new int[a.length];
    res[0] = 1;
    int total = 1;
    for (int i = 1; i < a.length; i++) {
      int tmp = 1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {
          tmp += res[j];
        } 
      }
      res[i] = tmp;
      total += tmp;
    }
    return total;
  }
}
