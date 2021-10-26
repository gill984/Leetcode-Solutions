class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxes;

    public MaxStack() {
        stack = new Stack<Integer>();
        maxes = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxes.isEmpty() || maxes.peek() <= x)
            maxes.push(x);
    }
    
    public int pop() {
        int x = stack.pop();
        if (maxes.peek() == x)
            maxes.pop();
        return x;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxes.peek();
    }
    
    public int popMax() {
        int x = maxes.pop();
        Stack<Integer> temp = new Stack<Integer>();
        while (x != stack.peek())
            temp.push(stack.pop());
        stack.pop();
        while (!temp.isEmpty())
        {
            int y = temp.pop();
            stack.push(y);
            if (maxes.isEmpty() || y >= maxes.peek())
                maxes.push(y);
        }
        
        return x;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */