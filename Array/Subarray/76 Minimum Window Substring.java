// 76 Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();

        Map<Character, Integer> targetcount = new HashMap<>();
        Map<Character, Integer> subCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
          if (targetcount.containsKey(t.charAt(i))) {
            targetcount.put(t.charAt(i), targetcount.get(t.charAt(i)) + 1);
          } else {
            targetcount.put(t.charAt(i), 1);
          }
        }

        // Use two pointers, i - slow pointer, j - fast pointer
        int j = 0;
        int matchedChars = 0;
        int start = 0, subStringLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          while (j < n && matchedChars < targetcount.size()) {
            int countOfCurrentChar = subCount.getOrDefault(s.charAt(j), 0);
            subCount.put(s.charAt(j), countOfCurrentChar + 1);
            if (subCount.get(s.charAt(j)).equals(
              targetcount.get(s.charAt(j))
            )) {
              matchedChars++;
            }
            j++;
          }

          if (matchedChars == targetcount.size()) {
            if (subStringLength > j - i) {
              subStringLength = j - i;
              start = i;
            }
          }

          int numOfThisChar = subCount.getOrDefault(s.charAt(i), 0);
          subCount.put(s.charAt(i), numOfThisChar - 1);
          if (subCount.get(s.charAt(i)).equals(
            targetcount.getOrDefault(s.charAt(i), 0) - 1
          )) {
            matchedChars--;
          }
        }

        if (subStringLength == Integer.MAX_VALUE) {
          return "";
        }

        return s.substring(start, start + subStringLength);
    }
}