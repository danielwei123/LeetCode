// 1047. Remove All Adjacent Duplicates In String

class Solution {
    public String removeDuplicates(String s) {
        if (s.length() == 1) return s;
        
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        stack.offerFirst(arr[0]);
        // everything on the left side of slow is 
        int pt = 1;
        
        while (pt < arr.length) {
            Character prev = stack.peekFirst();
            if (prev == null || arr[pt] != prev) {
                stack.offerFirst(arr[pt]);
            } else {
                stack.pollFirst();
            }
            pt++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}