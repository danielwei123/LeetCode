// 225. Implement Stack using Queues

class MyStack {
    private Queue<Integer> q;
    
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        // if (empty()) {
        //     return null;
        // }
        
        int size = q.size();
        while (--size > 0) {
            q.offer(q.poll());
        }
        
        return q.poll();
    }
    
    public int top() {
        // if (empty()) {
        //     return null;
        // }
        
        int ret = pop();
        q.offer(ret);
        return ret;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */