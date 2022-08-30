// 383. Ransom Note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // hashMap <Character, Integer>
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < magazine.length(); i++) {
            int count = map2.getOrDefault(magazine.charAt(i), 0);
            map2.put(magazine.charAt(i), count + 1);
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int count = map1.getOrDefault(ransomNote.charAt(i), 0) + 1;
            if (count > map2.getOrDefault(ransomNote.charAt(i), 0)) {
                return false;
            }
            map1.put(ransomNote.charAt(i), count);
        }
        
        return true;
    }
}