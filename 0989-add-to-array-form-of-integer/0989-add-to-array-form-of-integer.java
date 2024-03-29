class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        
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
                res.add(carry);
        }
        
        Collections.reverse(res);
        
        return res;
    }
}