class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        
        for (int i = 1; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        
        return b;
    }
}