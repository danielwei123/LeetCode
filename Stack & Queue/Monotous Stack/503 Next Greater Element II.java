// 503. Next Greater Element II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Use monotous stacks to find the next Greater element on the RHS
        // stack stores index rather than the actual values
        // The key of this problem is to loop twice!
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        int[] arr = new int[len];
        
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % len]) {
                stack.pop();
            }
            arr[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i % len);
        }
        
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr[i] == -1 ? -1 : nums[arr[i]];
        }
        return res;
    }
}