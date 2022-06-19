// 343. Integer Break

class Solution {
    public int integerBreak(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 1;
        M[2] = 1;
        for (int i = 3; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(M[j], j) * (i - j));
            }
            M[i] = curMax;
        }
        return M[n];
    }
}