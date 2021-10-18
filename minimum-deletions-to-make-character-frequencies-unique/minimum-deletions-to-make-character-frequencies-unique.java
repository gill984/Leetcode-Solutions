class Solution {
    public int minDeletions(String s) {
        int res = 0;
        int [] count = new int [26];
        for (char c : s.toCharArray())
            count[c - 'a'] += 1;
        Set<Integer> usedCounts = new HashSet<>();
        for (int i = 0; i < count.length; i++)
        {
            int num = count[i];
            while (num > 0 && usedCounts.contains(num))
            {
                num--;
            }
            
            res += (count[i] - num);
            usedCounts.add(num);
        }
        
        return res;
    }
}