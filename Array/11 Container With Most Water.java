// 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        // Two pointer
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            // Always move the smaller one to the inner array
            // because the smaller one will not be used in future calculation for max
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

// TC: O(n)
// SC: O(1)