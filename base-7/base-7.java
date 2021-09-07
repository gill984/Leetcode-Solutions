class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        
        int base = 7;
        Deque<Integer> digits = new ArrayDeque<Integer>();
        
        while (num != 0)
        {
            digits.push(num % base);
            num = num / base;
        }
        
        StringBuilder res = new StringBuilder();
        if (digits.peek() < 0)
            res.append("-");
        
        while (!digits.isEmpty())
        {
            res.append(Math.abs(digits.pop()));
        }
        
        return res.toString();
    }
}