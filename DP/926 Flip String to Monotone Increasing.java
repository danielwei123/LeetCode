// 926. Flip String to Monotone Increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        // DP
        // leftOnes[i] means how many 1s on the LHS of s.charAt(i)
        // rightZeros[i] means how many 0s on the LHS of s.charAt(i)
        // The min flips will be min(leftOnes[i] + rightZeros[i])
        int[] leftOnes = new int[s.length()];
        int[] rightZeros = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                leftOnes[i] = 0;
                rightZeros[s.length() - 1 - i] = 0;
            } else {
                leftOnes[i] = s.charAt(i - 1) == '1' ? leftOnes[i - 1] + 1 : leftOnes[i - 1];
                rightZeros[s.length() - 1 - i] = s.charAt(s.length() - i) == '0' ? rightZeros[s.length() - i] + 1 : rightZeros[s.length() - i] ;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, leftOnes[i] + rightZeros[i]);
        }
        
        return res;
    }
}