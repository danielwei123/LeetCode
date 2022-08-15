// 496. Next Greater Element I

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterIndex = new int[nums2.length];
        nextGreaterIndex[nums2.length - 1] = -1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Use a monotonous decreasing stack to store the index all the elements 
            // that are larger than the element of current index and on the RHS of current index
            while (!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]) {
                stack.pop();
            }
            nextGreaterIndex[i] = stack.isEmpty() ? -1 : stack.peek();           
            stack.push(i);
        }
        
        // store the map between nums2[i] and i
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = nextGreaterIndex[map.get(nums1[i])];
            res[i] = index != -1 ? nums2[index] : -1;
        }
        
        return res;
    }
}