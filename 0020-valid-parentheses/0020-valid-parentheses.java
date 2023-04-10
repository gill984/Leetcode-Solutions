class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peekLast() == '(') {
                stack.removeLast();
            } else if (c == ']' && stack.peekLast() == '[') {
                stack.removeLast();
            } else if (c == '}' && stack.peekLast() == '{') {
                stack.removeLast();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}