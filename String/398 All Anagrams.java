// 398 Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      // Sliding Window + HashMap
      List<Integer> res = new ArrayList<Integer>();
      if (s.length() == 0) {
        return res;
      }

      if (p.length() > s.length()) {
        return res;
      }

      // Record for each distinct character in s, how many characters are needed
      Map<Character, Integer> map = countMap(p);
      // Record how many characters have been matched
      int match = 0;

      for (int i = 0; i < s.length(); i++) {
        char tmp = s.charAt(i);
        Integer count = map.get(tmp);
        // handle the new added character(rightmost) at current sliding window
        if (count != null) {
          map.put(tmp, count - 1);
          if (count == 1) {
            match++;
          }
        }
        // handle the leftmost character at previous sliding window
        if (i >= p.length()) {
          tmp = s.charAt(i - p.length());
          count = map.get(tmp);
          if (count != null) {
            map.put(tmp, count + 1);
            if (count == 0) {
              match--;
            }
          }
        }

        if (match == map.size()) {
          res.add(i - p.length() + 1);
        }

      }

      return res;
    }
    
    private Map<Character, Integer> countMap(String s) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (char ch : s.toCharArray()) {
        Integer count = map.get(ch);
        if (count == null) {
          map.put(ch, 1);
        } else {
          map.put(ch, count + 1);
        }
      }
      return map;
    }
}