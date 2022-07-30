// 682. Longest Ascending Subsequence II

public class Solution {
  public int[] longest(int[] a) {
    // Write your solution here
    if (a.length == 0) {
      return new int[0];
    }

    int[] M = new int[a.length];
    int res = 0;
    int res_index = 0;
    for (int i = 0; i < a.length; i++) {
      M[i] = 1;
      for (int j = 0; j < i; j++) {
        if (a[j] < a[i]) {
          M[i] = Math.max(M[i], M[j] + 1);
        }
      }
      if (res < M[i]) {
        res = M[i];
        res_index = i;
      }
    }

    // backtrace from res_index to find path
    int[] output = new int[res];
    for (int i = res_index; i >= 0; i--) {
      if (M[i] == res) {
        output[--res] = a[i];
      }
    }
    
    return output;
  }
}
