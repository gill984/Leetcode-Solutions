class Solution {
    public int findMaximumXOR(int[] nums) {
        // Build a trie of binary digits
        // For each number navigate the trie and take the best possible path
        // The best possible path is choosing the number opposite of the digit you're
        // at currently
        Trie root = new Trie(0);
        for (int i : nums)
            root.insert(i);
        
        int res = 0;
        for (int i : nums)
            res = Math.max(res, root.getBestXOR(i));
        
        return res;
    }
    
    class Trie
    {
        int bit;
        Trie zero;
        Trie one;
        
        public Trie (int b)
        {
            bit = b;
        }
        
        public void insert(int val)
        {
            // Insert the string of 1s and 0s represented by val into the trie
            Trie curr = this;
            for (int i = 30; i >= 0; i--)
            {
                int digit = (val & (1 << i));
                
                if (digit == 0)
                {
                    if (curr.zero == null)
                    {
                        curr.zero = new Trie(0);
                    }
                    curr = curr.zero;
                }
                else
                {
                    if (curr.one == null)
                    {
                        curr.one = new Trie(1);
                    }
                    curr = curr.one;
                }
            }
        }
        
        public int getBestXOR(int a)
        {
            Trie curr = this;
            int b = 0;
            
            for (int i = 30; i >= 0; i--)
            {
                int digit = (a & (1 << i));
                
                if (digit == 0)
                {
                    if (curr.one == null)
                    {
                        curr = curr.zero;
                        b = b * 2;
                    }
                    else
                    {
                        curr = curr.one;
                        b = b * 2 + 1;
                    }
                }
                else
                {
                    if (curr.zero == null)
                    {
                        curr = curr.one;
                        b = b * 2 + 1;
                    }
                    else
                    {
                        curr = curr.zero;
                        b = b * 2;
                    }
                }
            }
            
            return (a ^ b);
        }
    }
}