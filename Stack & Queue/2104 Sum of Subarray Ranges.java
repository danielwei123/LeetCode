// 2104. Sum of Subarray Ranges

class Solution {
    public long subArrayRanges(int[] arr) {
      // DP + Monotonous stack
      // leftMin[i]: max length of subarry ending at arr[i] where arr[i] is the minumum value
      // rightMin[i]: max length of subarry starting at arr[i] where arr[i] is the minumum value
      // leftMax[i]: max length of subarry ending at arr[i] where arr[i] is the maximum value
      // rightMax[i]: max length of subarry starting at arr[i] where arr[i] is the maximum value
      int[] leftMin = new int[arr.length];
      int[] rightMin = new int[arr.length];
      int[] leftMax = new int[arr.length];
      int[] rightMax = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
        leftMin[i] = i + 1;
        rightMin[i] = arr.length - i;
        leftMax[i] = i + 1;
        rightMax[i] = arr.length - i;
      }
      
      // monotonous increasing stack storing the index of element
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
          stack.pop();
        }
        leftMin[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
      }
      
      // monotonous increasing stack storing the index of element
      stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
          rightMin[stack.peek()] = stack.isEmpty() ? i + 1 : i - stack.peek();
          stack.pop();
        }
        stack.push(i);
      }
      
      // monotonous decreasing stack storing the index of element
      stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
          stack.pop();
        }
        leftMax[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
      }
      
      // monotonous decreasing stack storing the index of element
      stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
          rightMax[stack.peek()] = stack.isEmpty() ? i + 1 : i - stack.peek();
          stack.pop();
        }
        stack.push(i);
      }
      
      long res = 0;
      // long MOD = (long)(Math.pow(10, 9) + 7);
      for (int i = 0; i < arr.length; i++) {        
        // res += ((long)arr[i] * (leftMax[i] * rightMax[i] - leftMin[i] * rightMin[i])) % MOD;
        res += (long)arr[i] * (leftMax[i] * rightMax[i] - leftMin[i] * rightMin[i]);
        
      }
      // return (int)(res % MOD);
      return res;
      
    }
}