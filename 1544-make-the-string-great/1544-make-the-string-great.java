class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            char counterPart = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
            if (res.length() == 0 || res.charAt(res.length() - 1) != counterPart) {
                res.append(c);
            } else {
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
}