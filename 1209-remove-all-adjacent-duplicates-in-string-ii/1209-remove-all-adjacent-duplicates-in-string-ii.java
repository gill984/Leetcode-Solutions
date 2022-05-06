class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Chain> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Chain(c, 1));
            } else {
                stack.peek().count++;
            }
            
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            Chain c = stack.pop();
            res.append((c.c + "").repeat(c.count));
        }
        
        return res.reverse().toString();
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