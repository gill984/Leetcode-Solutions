class CombinationIterator {
    int length;
    char[] s;
    StringBuilder curr;
    Deque<Integer> state;

    public CombinationIterator(String characters, int combinationLength) {
        s = characters.toCharArray();
        Arrays.sort(s);
        length = combinationLength;
        state = new ArrayDeque<>();
        curr = new StringBuilder();
    }
    
    public String next()
    {
        
        // Set up objects to first actual combination and return
        if (curr.length() == 0)
        {
            for (int i = 0; i < length; i++)
            {
                curr.append(s[i]);
                state.push(i);
            }
            return curr.toString();
        }
        
        // Subsequent calls need to modify the combination state
        int lastIndex = state.pop();
        deleteLast(curr);
        
        while (state.size() < length)
        {
            if (lastIndex == s.length - 1)
            {
                lastIndex = state.pop();
                deleteLast(curr);
            }
            else
            {
                lastIndex += 1;
                state.push(lastIndex);
                curr.append(s[lastIndex]);
            }
        }
        
        return curr.toString();
    }
    
    public boolean hasNext()
    {
        if (state.size() == 0)
            return true;
        
        for (int i : state)
            if (i < s.length - length)
                return true;
        return false;
    }
    
    private void deleteLast(StringBuilder curr)
    {
        curr.deleteCharAt(curr.length() - 1);
    }
}