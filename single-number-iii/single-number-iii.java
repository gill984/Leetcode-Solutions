class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int i : nums)
            x ^= i;
        
        // x is the two answers XOR'd
        // They are different numbers so there will
        // be a 1 bit set in x somewhere. Using this bit index
        // go back through the array and XOR those which have a 1 in
        // this index against those which have a 1, also XOR those which
        // have a 0 in this index against those which have a 0 here. At
        // the end you'll have your answer.
        int digit = 0;
        for (int i = 0; i <= 31; i++)
        {
            if ((x & (1 << i)) != 0)
            {
                digit = i;
                break;
            }
        }
        
        int one = 0;
        int zero = 0;
        for (int i : nums)
        {
            if ((i & (1 << digit)) == 0)
                zero ^= i;
            else
                one ^= i;
        }
        
        return new int [] {zero, one};
    }
}