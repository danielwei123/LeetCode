// 13. Roman to Integer

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char cur;
        char prev = s.charAt(s.length() - 1);
        int res = map.get(prev);
        for (int i = s.length() - 2; i >= 0; i--) {
            cur = s.charAt(i);
            if (map.get(cur) >= map.get(prev)) {
                res += map.get(cur);
            } else {
                res -= map.get(cur);
            }
            prev = cur;
        }
        
        return res;
    }
}