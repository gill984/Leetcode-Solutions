class MinStack {
    Stack<Integer> mins;
    Stack<Integer> nums;
    
    /** initialize your data structure here. */
    public MinStack() {
        mins = new Stack<Integer>();
        nums = new Stack<Integer>();
    }
    
    public void push(int x) {
        nums.push(x);
        if (mins.size() == 0 || mins.peek() >= x)
            mins.push(x);
    }
    
    public void pop() {
        int x = nums.pop();
        if (x == mins.peek())
            mins.pop();
    }
    
    public int top() {
        return nums.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}