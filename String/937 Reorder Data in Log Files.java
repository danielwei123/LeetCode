// 937. Reorder Data in Log Files

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1FirstSpaceIndex = s1.indexOf(' ');
                int s2FirstSpaceIndex = s2.indexOf(' ');
                // s1 is digit-log
                if (s1.charAt(s1FirstSpaceIndex + 1) <= '9') {
                    // digit-logs maintain their relative ordering
                    if (s2.charAt(s2FirstSpaceIndex + 1) <= '9') {
                        return 0;
                    } else {
                        // s2 is letter-log
                        // letter-logs come before digit-logs
                        return 1;
                    }
                } else {
                   if (s2.charAt(s2FirstSpaceIndex + 1) <= '9') {
                       return -1;
                   }  else {
                       int compare = s1.substring(s1FirstSpaceIndex + 1).compareTo(s2.substring(s2FirstSpaceIndex + 1));
                       if (compare == 0) return s1.substring(0, s1FirstSpaceIndex).compareTo(s2.substring(0, s2FirstSpaceIndex));
                       return compare;
                   }
                }
            }
        };
        
        Arrays.sort(logs, myComparator);
        return logs;
    }
}