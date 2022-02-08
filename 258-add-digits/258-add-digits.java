class Solution {
    public int addDigits(int num) {
        String numString = num + "";
        while (numString.length() > 1)
        {
            num = compact(numString);
            numString = num + "";
        }
        
        return num;
    }
    
    public int compact(String s)
    {
        int res = 0;
        
        for (char c : s.toCharArray())
        {
            res += c - '0';
        }
        
        return res;
    }
}