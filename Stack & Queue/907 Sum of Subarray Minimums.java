// 907. Sum of Subarray Minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
      // DP + Monotonous stack
      // left[i]: max length of subarry ending at arr[i] where arr[i] is the minumum value
      // right[i]: max length of subarry starting at arr[i] where arr[i] is the minumum value
      int[] left = new int[arr.length];
      int[] right = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
        left[i] = i + 1;
        right[i] = arr.length - i;
      }
      
      // monotonous increasing stack storing the index of element
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
          stack.pop();
        }
        left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
      }
      
      // monotonous increasing stack storing the index of element
      stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
          right[stack.peek()] = stack.isEmpty() ? i + 1 : i - stack.peek();
          stack.pop();
        }
        stack.push(i);
      }
      
      long res = 0;
      long MOD = (long)(Math.pow(10, 9) + 7);
      for (int i = 0; i < arr.length; i++) {        
        res += ((long)arr[i] * left[i] * right[i]) % MOD;
      }
      return (int)(res % MOD);
            
    }
  
  
  
}