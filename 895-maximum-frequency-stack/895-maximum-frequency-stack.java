class FreqStack {
    Map<Integer, Integer> valToFreq;
    List<ArrayDeque<Integer>> stacks;

    public FreqStack() {
        stacks = new ArrayList<>();
        valToFreq = new HashMap<>();
    }
    
    public void push(int val)
    {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        if (stacks.size() < freq)
            stacks.add(new ArrayDeque<Integer>());
        stacks.get(freq - 1).push(val);
        valToFreq.put(val, freq);
    }
    
    public int pop() {
        int last = stacks.size() - 1;
        int val = stacks.get(last).pop();
        if (stacks.get(last).isEmpty())
            stacks.remove(last);
        valToFreq.put(val, valToFreq.get(val) - 1);
        return val;
    }
}