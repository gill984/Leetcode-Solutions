class Solution {
    public String getSmallestString(int n, int k) {
        // Greedy approach, put the smallest possible character at the front
        int sum = 0;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < n; i++)
        {
            // Check to see what character we can add
            int choice = k - (sum + ((n - i - 1) * 26));
            char c = (choice <= 1 ? 'a' : (char)('a' + choice - 1));
            res.append(c);
            sum += c - 'a' + 1;
        }
        
        return res.toString();
    }
}