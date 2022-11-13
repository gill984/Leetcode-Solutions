class Solution {
    public String reverseWords(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= -1; i--) {
            if (i >= 0 && s.charAt(i) != ' ') {
                stack.addLast(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (res.length() != 0) {
                    res.append(' ');
                }
                
                while (!stack.isEmpty()) {
                    res.append(stack.removeLast());
                }
            }
        }
        
        return res.toString();
    }
}