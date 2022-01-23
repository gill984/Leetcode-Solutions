class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // Generate all the numbers with sequential digits
        // Generate them from smallest to largest
        // Generate the first sequential number and make sure it's in the range, then go from there
        String lowDigits = "" + low;
        String highDigits = "" + high;
        
        int lowLength = lowDigits.length();
        int highLength = highDigits.length();
        
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();
        
        for (char c : lowDigits.toCharArray())
        {
            lowList.add(c - '0');
        }
        
        for (char c : highDigits.toCharArray())
        {
            highList.add(c - '0');
        }
        
        List<Integer> res = new ArrayList<>();
        
        
        for (int length = lowLength; length <= highLength; length++)
        {
            int startDigit = (length == lowLength ? lowList.get(0) : 1);
            // System.out.println(startDigit);
            
            for (; 9 - startDigit + 1 >= length; startDigit++)
            {
                
                int val = 0;
                for (int digit = startDigit; digit - startDigit < length; digit++)
                {
                    val = (val * 10) + digit;
                    // System.out.println("digit: " + digit);
                    // System.out.println("val: " + val);
                }
                
                // System.out.println(val);
                
                if (val >= low && val <= high)
                {
                    res.add(val);
                }
                else if (val < low)
                {
                    continue;
                }
                else
                {
                    // We've gone over high, there are no more
                    // sequential numbers
                    return res;
                }
            }
        }
        
        return res;
    }
}