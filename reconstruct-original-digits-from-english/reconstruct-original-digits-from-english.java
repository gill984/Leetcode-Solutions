class Solution
{
    public String originalDigits(String s)
    {
        int [] count = new int [26];
        int [] resArray = new int [10];
        
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a'] += 1;
        
        resArray[0] = count['z' - 'a'];
        resArray[2] = count['w' - 'a'];
        resArray[4] = count['u' - 'a'];
        resArray[6] = count['x' - 'a'];
        resArray[8] = count['g' - 'a'];
        resArray[3] = count['h' - 'a'] - resArray[8];
        resArray[5] = count['f' - 'a'] - resArray[4];
        resArray[7] = count['s' - 'a'] - resArray[6];
        resArray[9] = count['i' - 'a'] - resArray[5] - resArray[6] - resArray[8];
        resArray[1] = count['o' - 'a'] - resArray[2] - resArray[4] - resArray[0];
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < resArray[i]; j++)
                output.append(i);
        
        return output.toString();
    }
}