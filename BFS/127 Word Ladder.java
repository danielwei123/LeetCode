// 127. Word Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 2-way BFS
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Deque<String> beginQueue = new ArrayDeque<>(), endQueue = new ArrayDeque<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        beginQueue.offerFirst(beginWord);
        endQueue.offerFirst(endWord);
                
        if (!wordList.contains(endWord)) return 0;
        if (beginWord == endWord) return 1;
        
        int beginStep = 0, endStep = 1;
        
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginQueueSize = beginQueue.size();
            int endQueueSize = endQueue.size();
            boolean beginHasNext = false, endHasNext = false;
            // BFS from beginQueue
            for (int i = 0; i < beginQueueSize; i++) {
                String cur = beginQueue.pollLast();
                if (endSet.contains(cur)) {
                    return beginStep + endStep;
                }
                
                for (int j = 0; j < wordList.size(); j++) {
                    String tmp = wordList.get(j);
                    if (!beginSet.contains(tmp) && isValid(cur, tmp)) {
                        beginQueue.offerFirst(tmp);
                        beginSet.add(tmp);
                        beginHasNext = true;
                    }
                }
            }
            if (beginHasNext) beginStep++;
            
            // BFS from endQueue
            for (int i = 0; i < endQueueSize; i++) {
                String cur = endQueue.pollLast();
                if (beginSet.contains(cur)) {
                    return beginStep + endStep;
                }
                
                for (int j = 0; j < wordList.size(); j++) {
                    String tmp = wordList.get(j);
                    if (!endSet.contains(tmp) && isValid(cur, tmp)) {
                        endQueue.offerFirst(tmp);
                        endSet.add(tmp);
                        endHasNext = true;
                    }
                }
            }
            if (endHasNext) endStep++;
        }
        
        return 0;
    }
    
    // check if s1 and s2 only has one character difference
    private boolean isValid(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                diffCount++;
                if (diffCount > 1) return false;
            }
        }
        return true;
    }
}