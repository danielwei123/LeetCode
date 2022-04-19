// 153. Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {
        // equivalent to find the first element that is less than nums[0]; use binary search
      int left = 0;
      int right = nums.length - 1;
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[0]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      
      return Math.min( Math.min(nums[left], nums[right]), nums[0]);
    }
}