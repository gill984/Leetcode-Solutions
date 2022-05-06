class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Chain> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peekLast().c != c) {
                stack.addLast(new Chain(c, 1));
            } else {
                stack.peekLast().count++;
            }
            
            if (stack.peekLast().count == k) {
                stack.removeLast();
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            Chain c = stack.removeFirst();
            res.append((c.c + "").repeat(c.count));
        }
        
        return res.toString();
    }
    
    class Chain {
        char c;
        int count;
        
        public Chain(char c, int n) {
            this.c = c;
            this.count = n;
        }
    }
}