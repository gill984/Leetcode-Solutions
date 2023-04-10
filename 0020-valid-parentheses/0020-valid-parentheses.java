class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.addLast(c);
            else if (stack.isEmpty())
                return false;
            else if (stack.peekLast() == c - 1 || stack.peekLast() == c - 2)
                stack.removeLast();
            else
                return false;
        }
        
        return stack.isEmpty();
    }
}