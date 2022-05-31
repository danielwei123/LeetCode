// 80. Remove Duplicates from Sorted Array II

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Everything on the LHS of slow is to be kept
        // Everything on the LHS of fast is processed
        int slow = 0;
        int fast = 0;
        int count = 0;
        
        while (fast < nums.length) {
            if (fast == 0 || nums[fast] == nums[slow - 1]) {
                if (count <= 1) {
                    nums[slow++] = nums[fast++];
                } else {
                    fast++;
                }
                count++;
            } else {
                nums[slow++] = nums[fast++];               
                count = 1;
            }

        }
        
        return slow;
    }
}