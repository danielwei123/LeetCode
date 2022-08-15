// 316. Remove Duplicate Letters

class Solution {
    public String removeDuplicateLetters(String s) {
        // Use index[] to store the last index where letter i occurs
        // index[0]: the largest index where s.charAt(i) == 'a'
        // index[25]: the largest index where s.charAt(i) == 'z'
        // Use used[] to store whether a letter has been used
        // Use monotous stack to store selected letters in lexicographical order so far
        int len = s.length();
        int[] index = new int[26];
        boolean[] used = new boolean[26];
        Deque<Character> dq = new ArrayDeque<>();
        
        Arrays.fill(index, -1);
        Arrays.fill(used, false);
        
        for (int i = len - 1; i >= 0; i--) {
            if (index[s.charAt(i) - 'a'] == -1) {
                index[s.charAt(i) - 'a'] = i;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (used[s.charAt(i) - 'a']) continue;
            while (!dq.isEmpty() && dq.peekLast() > s.charAt(i)) {
                // if there's anohter index of stack.peek() on the RHS of i
                // then we can stack.pop() and mark it as unused
                if (index[dq.peekLast() - 'a'] > i) {
                    used[dq.peekLast() - 'a'] = false;
                    dq.pollLast();
                } else {
                    break;
                }
            }
            dq.offerLast(s.charAt(i));
            used[s.charAt(i) - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}