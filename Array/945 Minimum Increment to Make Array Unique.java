// 945. Minimum Increment to Make Array Unique

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        // need: the min value needed at current index: current needs be at least prev + 1
        int res = 0, need = 0;
        for (int a: nums) {
            res += Math.max(need - a, 0);
            need = Math.max(need, a) + 1;
        }
        return res;
    }
}