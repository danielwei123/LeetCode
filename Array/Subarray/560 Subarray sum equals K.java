// 560. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {
      // Use PrefixSum + HashMap
      int[] prefixSum = getPrefixSum(nums);
      int ans = 0;

      // key: prefixSum
      // value: how many index has this prefixSum
      Map<Integer, Integer> sum2index = new HashMap<>();
      sum2index.put(0,1);
      for (int end = 0; end < nums.length; end++) {
        if (sum2index.containsKey(prefixSum[end + 1] - k)) {
          int count = sum2index.get(prefixSum[end + 1] - k);
          ans += count;
        }
        
        if (!sum2index.containsKey(prefixSum[end + 1])) {
          sum2index.put(prefixSum[end + 1], 1);
        } else {
          sum2index.put(prefixSum[end + 1], sum2index.get(prefixSum[end + 1]) + 1);
        }
      }

      return ans;
    }
  
    private int[] getPrefixSum(int[] nums) {
      int[] res = new int[nums.length + 1];
      res[0] = 0;
      for (int i = 1; i < nums.length + 1; i++) {
        res[i] = res[i - 1] + nums[i - 1];
      }
      return res;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)