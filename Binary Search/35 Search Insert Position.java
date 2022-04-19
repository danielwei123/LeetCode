// 35. Search Insert Position

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

class Solution {
    public int searchInsert(int[] input, int target) {
        if (input == null || input.length == 0) {
        return 0;
      }

      int left = 0;
      int right = input.length - 1;
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (input[mid] >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      if (input[left] >= target) {
        return left;
      } else if (input[right] >= target) {
        return right;
      } else {
        return right + 1;
      }
    }
}