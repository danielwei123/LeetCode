// Amazon OA - Count pairs in array whose sum is divisible by K

public int countPairs(int[] nums, int k) {
    // Create an array to store the numbers of element based on mod k
    int[] modCount = new int[k];
    for (int i = 0; i < nums.length; i++) {
        modCount[nums[i] % k]++;
    }
    
    int res = 0;
    if (modCount[0] >= 2) {
        res += modCount[0] * (modCount[0] - 1) / 2;
    }
    
    for (int i = 1; i < k / 2; i++) {
        res += modCount[i] * modCount[k  -i];
    }
    
    if (k % 2 ==  0 && modCount[k / 2] > 1) {
        res += modCount[k / 2] * (modCount[k / 2] - 1) / 2;
    }
    
    if (k % 2 == 1) {
        res += modCount[k / 2] * modCount[k - k / 2];
    }
    
    return res;
}