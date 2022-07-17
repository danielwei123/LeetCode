// 205. Isomorphic Strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indexPatternS = getIndexPattern(s);
        int[] indexPatternT = getIndexPattern(t);
        for (int i = 0; i < indexPatternS.length; i++) {
            if (indexPatternS[i] != indexPatternT[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] getIndexPattern(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int[] res = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                res[i] = map.get(s.charAt(i));
            } else {
                res[i] = count;
                map.put(s.charAt(i), count++);
            }
        }
        return res;
    }
}