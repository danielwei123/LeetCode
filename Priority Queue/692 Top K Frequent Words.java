// 692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // HashMap + PriorityQueue
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        PriorityQueue<Freq> minHeap = new PriorityQueue<>(k, new Comparator<Freq>(){
            @Override
            public int compare(Freq m1, Freq m2){
                if (m1.freq == m2.freq) {
                    return -1 * m1.str.compareTo(m2.str);
                } else {
                    return m1.freq - m2.freq;
                }
            }
        });
        
        for (String s: map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(new Freq(s, map.get(s)));
            } else {
                Freq top = minHeap.peek();
                if (map.get(s) > top.freq || (map.get(s) == top.freq && s.compareTo(top.str) < 0)) {
                    minHeap.poll();
                    minHeap.offer(new Freq(s, map.get(s)));
                }
            }
        }
        
        String[] tmp = new String[k];
        List<String> res = new ArrayList<>();
        int count = 0;
        while (!minHeap.isEmpty()) {
            tmp[count++] = minHeap.poll().str;
        }
        
        count--;
        while (count >= 0) {
            res.add(tmp[count--]);
        }
        
        return res;
        
    }
}

class Freq {
    String str;
    int freq;
    Freq(String s, int count) {
        this.str = s;
        this.freq = count;
    }
}