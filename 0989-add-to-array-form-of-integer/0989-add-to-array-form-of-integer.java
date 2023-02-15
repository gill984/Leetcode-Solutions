class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        
        // System.out.println(res);
        
        int carry = 0;
        int i = 0;
        for (int ndx = num.length - 1; ndx >= 0 || (i < res.size()); ndx--, i++) {
            int val = (i < res.size() ? res.get(i) : 0);
            val = val + (ndx >= 0 ? num[ndx] : 0) + carry;
            carry = val / 10;
            val = val % 10;
            if (i < res.size()) {
                res.set(i, val);
            } else {
                res.add(val);
            }
        }
        
        if (carry > 0) {
            if (i == res.size())
                res.add(carry);
            else
                res.set(i, carry);
        }
        
        Collections.reverse(res);
        
        return res;
    }
}