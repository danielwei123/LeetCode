// 1052. Grumpy Bookstore Owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // Sliding Window
        int sum = 0;
        
        for (int i = 0; i < customers.length; i++) {
            if (i < minutes) {
                sum += customers[i];
            } else {
                sum += customers[i] * (1 - grumpy[i]);
            }
        }
        
        int maxSum = sum;
        int left = 1;
        int right = minutes;
        
        while (right < customers.length) {
            sum = sum - customers[left - 1] + customers[left - 1] * (1 - grumpy[left - 1]) + customers[right] - customers[right] * (1 - grumpy[right]);
            maxSum = Math.max(maxSum, sum);
            left++;
            right++;
        }
        
        return maxSum;
    }
}