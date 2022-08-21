// 678. Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        // use a map to store the number of each different character in String s so far
        // two pass to make sure the 3rd rule: 
        // Otherwise: "((*))(" will fail
        Map<Character, Integer> map = new HashMap<>();
        // iterate from left to right
        map.put('(', 0);
        map.put(')', 0);
        map.put('*', 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
            if (map.get(')') > map.get('(') + map.get('*')) return false;
        }
        if (map.get('(') > map.get(')') + map.get('*')) return false;
        
        // iterate from left to right
        map.put('(', 0);
        map.put(')', 0);
        map.put('*', 0);     
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
            if (map.get('(') > map.get(')') + map.get('*')) return false;
        }
        if (map.get(')') > map.get('(') + map.get('*')) return false;
        
        return true;
    }
}