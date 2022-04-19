// 189. Rotate Array

// Given an array, rotate the array to the right by k steps, where k is non-negative.

class Solution {
    public void rotate(int[] nums, int k) {
      k %= nums.length;      
      rotateHelper(nums, 0, nums.length - k - 1);
      rotateHelper(nums, nums.length - k, nums.length - 1);
      rotateHelper(nums, 0, nums.length - 1);
      return;
    }
  
    private void rotateHelper(int[] nums, int left, int right) {
      while (left <= right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        left++;
        right--;
      }
      return;
    }
}