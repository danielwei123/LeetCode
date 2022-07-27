// 84. Largest Rectangle in Histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        // The stack contains the "index", not the value of the array
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i <= heights.length; i++) {
          int cur = i == heights.length ? 0 : heights[i];
          while (!stack.isEmpty() && heights[stack.peekFirst()] >= cur) {
            int height = heights[stack.pollFirst()];
            int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
            result = Math.max(result, height * (i - left));
          }
          stack.offerFirst(i);
        }
        return result;
    }
}