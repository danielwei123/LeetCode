// 132. Palindrome Partitioning II

class Solution {
    public int minCut(String s) {
      // leastCut[i] means the minimum cuts for substring from index 0 to index i
      if (s == null || s.length() == 0) {
        return 0;
      }
      int[] leastCut = new int[s.length()];
      leastCut[0] = 0;
      for (int i = 1; i < s.length(); i++) {
        if (isPalindrome(s, 0, i)) {
          leastCut[i] = 0;
        } else {
          int curMin = Integer.MAX_VALUE;
          for (int j = 0; j < i; j++) {
            if (isPalindrome(s, j + 1, i)) {
              curMin = Math.min(curMin, leastCut[j] + 1);
            }
          }
          leastCut[i] = curMin;
        }
      }

      return leastCut[s.length() - 1];
    }
  
    private boolean isPalindrome(String str, int l, int r) {
      while (l < r) {
        if (str.charAt(l) != str.charAt(r)) {
          return false;
        } else {
          l++;
          r--;
        }
      }
      return true;
    }
}