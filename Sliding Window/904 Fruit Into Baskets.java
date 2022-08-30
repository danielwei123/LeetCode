// 904. Fruit Into Baskets

class Solution {
    public int totalFruit(int[] fruits) {
        // sliding window + HashMap
        // map: key - fruit typem, value - the last index of key within current window
        Map<Integer, Integer> map = new HashMap<>();
        int maxRes = 0;
        int curCount = 0;
        // slow, fast: left and right border of the sliding window
        // slow: inclusive, fast: exclusive
        int slow = 0;
        int fast = 0;
        while (fast < fruits.length) {
            if (map.size() < 2 || map.containsKey(fruits[fast])) {
                map.put(fruits[fast], fast);
                curCount++;
            } else {
                map.put(fruits[fast], fast);
                curCount++;
                while (slow < fast && map.size() > 2) {
                    if (map.get(fruits[slow]) != slow) {
                        slow++;
                        curCount--;
                    } else {
                        map.remove(fruits[slow++]);
                        curCount--;
                        break;
                    }
                }
            }
            maxRes = Math.max(maxRes, curCount);
            fast++;
        }
        
        return maxRes;
    }
}