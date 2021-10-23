class FreqStack {
    Map<Integer, Integer> valToFreq;
    List<Stack<Integer>> stacks;

    public FreqStack() {
        stacks = new ArrayList<>();
        valToFreq = new HashMap<>();
    }
    
    public void push(int val)
    {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        if (stacks.size() < freq)
            stacks.add(new Stack<Integer>());
        stacks.get(freq - 1).push(val);
        valToFreq.put(val, freq);
    }
    
    public int pop() {
        int val = stacks.get(stacks.size() - 1).pop();
        if (stacks.get(stacks.size() - 1).isEmpty())
        {
            stacks.remove(stacks.size() - 1);
        }
        valToFreq.put(val, valToFreq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */