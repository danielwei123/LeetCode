// 239. Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        // Use deque to store index instead of actual values
        // The values in deque will always be a descending list, with the first element to be the maximum value
        // Update case 1: if new element is larger than previous element in queue
        // Update case 2: if most left element is the largest value 
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
          while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
          }
          if (!deque.isEmpty() && deque.peekFirst() == i - k) {
            deque.pollFirst();
          }
          deque.offerLast(i);
          if (i >= k - 1) {
            max[i - k + 1] = nums[deque.peekFirst()];
          }
        }
        return max;
    }
}