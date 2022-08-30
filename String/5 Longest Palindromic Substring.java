// 5. Longest Palindromic Substring

class Solution {
    public String longestPalindrome(String s) {
        // iterate the whole string, at each index i, do the following operations:
        // 1. find the farthest index r on the RHS of i which s.charAt(r) equals to s.charAt(i), i.e. i to r are same letters
        // 2. find the farthest index l on the LHS of i which s.charAt(l) equals to s.charAt(i), i.e. l to l are same letters
        // 3. keep l-- and r++ to compare if s.charAt(l) == s.charAt(r)
        // 4. update longest result
        
        int maxLen = 0;
        String res = "";
        for (int i = 0 ; i < s.length(); i++) {
            int r = i, l = i;
            // Step 1
            while (r < s.length()) {
                if (s.charAt(r) == s.charAt(i)) {
                    r++;
                } else {
                    break;
                }
            }
            // Step 2
            while (l >= 0) {
                if (s.charAt(l) == s.charAt(i)) {
                    l--;
                } else {
                    break;
                }
            }
            // Step 3
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            
            // Step 4
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                res = s.substring(l + 1, r);
            }            
        }
        return res;
    }
}

// TC: O(n^2)
// TC: O(n)     substring() need O(n)