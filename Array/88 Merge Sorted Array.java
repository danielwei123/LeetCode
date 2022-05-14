// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Use two pointser, but iterate from right to right
        int[] res = new int[m + n];
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0 && i >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i];
                nums1[i--] = 0;
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        if (i < 0) {
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
        
        return;
    }
}