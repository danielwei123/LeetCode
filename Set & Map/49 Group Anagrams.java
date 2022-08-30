// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sort each string in the array, then anagrams will turn into the same string
        // Use a map to store <sorted_string, list_of_origin_string>
        String[] sortedStrs = new String[strs.length];
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0 ; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            sortedStrs[i] = sortedStr;
            if (!map.containsKey(sortedStr)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(sortedStr, tmp);
            } else {
                List<String> tmp = map.get(sortedStr);
                tmp.add(strs[i]);
                map.put(sortedStr, tmp);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String s: map.keySet()) {
            res.add(map.get(s));
        }
        
        return res;
    }
}