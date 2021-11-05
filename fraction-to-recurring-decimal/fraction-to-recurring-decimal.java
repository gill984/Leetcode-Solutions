class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        
        StringBuilder res = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0))
            res.append("-");
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        res.append(num / den);
        num = num % den;
        if (num == 0) {
            return res.toString();
        }
            
        res.append(".");
        Map<Long, Integer> numToIndex = new HashMap<>();
        numToIndex.put(num, res.length());
        
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num = num % den;
            
            if (numToIndex.containsKey(num)) {
                int index = numToIndex.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                numToIndex.put(num, res.length());
            }
        }
        
        return res.toString();
    }
}