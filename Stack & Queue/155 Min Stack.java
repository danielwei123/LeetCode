// 155. Min Stack

class MinStack {

    private Deque<Integer> q;
    private int minVal;
    
    public MinStack() {
        q = new ArrayDeque<Integer>();  
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        q.offerFirst(val);
        minVal = Math.min(val, minVal);
    }
    
    public void pop() {
        int popVal = q.pollFirst();
        if (popVal == minVal) {
            int size = q.size();
            minVal = Integer.MAX_VALUE;
            while (size-- > 0) {
                int tmp = q.pollLast();
                minVal = Math.min(tmp, minVal);
                q.offerFirst(tmp);
            }
        }
    }
    
    public int top() {
        return q.peekFirst();
    }
    
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */