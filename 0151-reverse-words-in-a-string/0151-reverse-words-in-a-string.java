class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int n = s.length();
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i <= n; i++) {
            if (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else if (word.length() > 0) {
                stack.addLast(word.toString());
                word = new StringBuilder();
            }
        }
        
        while (!stack.isEmpty()) {
            res.append(stack.removeLast());
            if (!stack.isEmpty())
                res.append(' ');
        }
        
        return res.toString();
    }
}