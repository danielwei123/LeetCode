class Solution {
    public boolean isMatch(String s, String p) {
        // https://leetcode.com/problems/wildcard-matching/discuss/270729/java-13ms-dp-solution-with-explanation
        
        // match[i][j]: whether s.substring(0, i) matches p.substring(0, j)
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        
        // check if substring of p matches empty string
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                match[0][i + 1] = match[0][i];
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    match[i + 1][j + 1] = match[i][j] || match[i + 1][j] || match[i][j + 1];
                } else {
                    match[i + 1][j + 1] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') ? match[i][j] : false;
                }
            }
        }
        
        return match[s.length()][p.length()];
        
    }   
}