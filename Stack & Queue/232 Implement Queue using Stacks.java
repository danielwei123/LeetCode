// 232. Implement Queue using Stacks


class MyQueue {

    private Deque<Integer> in;
    private Deque<Integer> out;
    
    public MyQueue() {
        in = new LinkedList<Integer>();    
        out = new LinkedList<Integer>();    
    }
    
    public void push(int x) {
        in.offerLast(x);
    }
    
    public int pop() {
        if (!out.isEmpty()) {
            return out.pollLast();
        } else {
            move();
            return out.pollLast();
        }
    }
    
    public int peek() {
        if (!out.isEmpty()) {
            return out.peekLast();
        } else {
            move();
            return out.peekLast();
        }
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void move() {
        // move all elements from in to out
        while (!in.isEmpty()) {
            out.offerLast(in.pollLast());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
