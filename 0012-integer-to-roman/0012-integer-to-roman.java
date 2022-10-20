class Solution {
    public String intToRoman(int num) {
        int [] vals = new int [] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] strs = new String [] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int idx = 0;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        while (sum < num) {
            if (sum + vals[idx] <= num) {
                sum += vals[idx];
                res.append(strs[idx]);
            } else {
                idx++;
            }
        }
        
        return res.toString();
    }
}