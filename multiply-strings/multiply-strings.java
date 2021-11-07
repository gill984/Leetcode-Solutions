class Solution {
    public String multiply(String num1, String num2) {
        char [] a = num1.toCharArray();
        char [] b = num2.toCharArray();
        int [] c = new int [a.length + b.length];
        
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                int aDigit = a[a.length - 1 - i] - '0';
                int bDigit = b[b.length - 1 - j] - '0';
                
                // How many trailing zeroes to add
                int place = i + j;
                
                int product = aDigit * bDigit;
                
                c[c.length - 1 - place] += product % 10;
                if (c[c.length - 1 - place] > 9)
                {
                    c[c.length - 2 - place] += 1;
                    c[c.length - 1 - place] -= 10;
                }
                
                c[c.length - 2 - place] += product / 10;
                if (c[c.length - 2 - place] > 9)
                {
                    c[c.length - 3 - place] += 1;
                    c[c.length - 2 - place] -= 10;
                }
            }
        }
        
        boolean nonZeroFound = false;
        StringBuilder res = new StringBuilder();
        for (int start = 0; start < c.length; start++)
        {
            if (c[start] != 0)
            {
                nonZeroFound = true;
                res.append(c[start]);
            }
            else if (nonZeroFound)
            {
                res.append(c[start]);
            }
        }
        
        if (res.length() == 0)
            return "0";
        else
            return res.toString();
    }
}