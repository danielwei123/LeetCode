// 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] array, int target) {
      // 1. Use Binary Search to find the index i where array[i] is the last elememt >= array[0]
      // 2. Use Binary Search to find whether A[j] exists within the subarray
      if (array == null || array.length == 0) return -1;

      int left = 0;
      int right = array.length - 1;
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] >= array[0]) {
          left = mid;
        } else {
          right = mid;
        }
      }

      int lastIndex = array[left] > array[right] ? left : right;

      if (target >= array[0]) {
        return BinarySearch(array, 0, lastIndex, target);
      } else {
        return BinarySearch(array, lastIndex + 1, array.length - 1, target);
      }
    }
  
    private int BinarySearch(int[] arr, int left, int right, int t) {
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == t) {
          return mid;
        } else if (arr[mid] > t) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      return -1;
    }
}