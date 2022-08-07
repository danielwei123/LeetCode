// 2262. Total Appeal of A String

class Solution {
    public long appealSum(String s) {
        // DP
        // prev[i] stores the prev index where char c exists in String s;
        // initialize as -1
        int[] prev = new int[26];
        for (int i = 0; i < 26; i++) {
            prev[i] = -1;
        }
        // appeal[i] represents the number of appeals of substrings ending at index i
        int[] appeal = new int[s.length()];
        appeal[0] = 1;
        prev[s.charAt(0) - 'a'] = 0;
        long sum = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int len = prev[s.charAt(i) - 'a'] == -1 ? i + 1 : i - prev[s.charAt(i) - 'a'];
            appeal[i] = appeal[i-1] + len;
            prev[s.charAt(i) - 'a'] = i;
            sum += appeal[i];
        }
        
        return sum;
    }
}