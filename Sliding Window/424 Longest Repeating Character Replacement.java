// 424. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window 
        // letter[0]: how many times have letter 'A' occurs in String s 
        char[] letter = new char[26];
        int left = 0;
        int right = 0;
        // maxCount:  many times does the most frequent letter in the current subString occur
        int maxCount = 0;
        int res = 0;
        while (right < s.length()) {
            letter[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, letter[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                letter[s.charAt(left++) - 'A']--;
                // update maxCount
                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    maxCount = Math.max(maxCount, letter[i]);
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}