class MyStack {
    Queue<Integer> a;
    Queue<Integer> b;
    
    public MyStack() {
        a = new LinkedList<>();
    }
    
    public void push(int x) {
        a.add(x);
    }
    
    public int pop() {
        int n = a.size();
        for (int i = 0; i < n - 1; i++)
            a.add(a.poll());
        
        return a.poll();
    }
    
    public int top() {
        int n = a.size();
        for (int i = 0; i < n - 1; i++)
            a.add(a.poll());
        int res = a.poll();
        a.add(res);
        return res;
    }
    
    public boolean empty() {
        return a.isEmpty();
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