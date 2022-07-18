// 26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        // slow: everything on the LHS of slow node is the ones will be kept [0, slow - 1]
        // fast: everything on the LHS of fast node is the ones have be checked [0, fast - 1]
        int slow = 1;
        int fast = 1;
        
        while (fast < nums.length) {
            if (nums[fast] > nums[slow - 1]) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        
        return slow;
    }
}