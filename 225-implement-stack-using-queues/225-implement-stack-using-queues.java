class MyStack {
    Queue<Integer> a;
    Queue<Integer> b;
    
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!a.isEmpty()) {
            a.add(x);
        } else {
            b.add(x);
        }
    }
    
    public int pop() {
        if (a.isEmpty()) {
            while (b.size() > 1) {
                a.add(b.poll());
            }
            return b.poll();
        } else {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            return a.poll();
        }
    }
    
    public int top() {
        if (a.isEmpty()) {
            while (b.size() > 1) {
                a.add(b.poll());
            }
            int res = b.poll();
            a.add(res);
            return res;
        } else {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            int res = a.poll();
            b.add(res);
            return res;
        }
    }
    
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
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