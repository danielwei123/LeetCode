// 373. Find K Pairs with Smallest Sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // PriorityQueue + k-way merge
        // https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
        // Check the first comments for explanation
        PriorityQueue<Point> minHeap = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                return p1.sum - p2.sum;
            }
        });
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new Point(i, 0, nums1, nums2));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        long MOD = 1000000007;
        long maxLen = ((long)nums1.length * (long)nums2.length) % MOD;
        for (int i = 0; i < Math.min(maxLen, k); i++) {
            Point cur = minHeap.poll();
            tmp = new ArrayList<Integer>();
            tmp.add(nums1[cur.x]);
            tmp.add(nums2[cur.y]);
            res.add(tmp);
            
            if (cur.y == nums2.length - 1) continue;
            minHeap.offer(new Point(cur.x, cur.y + 1, nums1, nums2));
        }
        
        return res;
    }
}

class Point {
    int x;
    int y;
    int sum;
    Point(int i1, int i2, int[] nums1, int[] nums2) {
        x = i1;
        y = i2;
        sum = nums1[i1] + nums2[i2];
    }
}

// TC: O(klogk)
// SC: O(k)