class Solution {
    public int[] twoSum(int[] numbers, int k) {
        int lo = 0;
        int hi = numbers.length - 1;
        int [] res = new int [2];
        
        while (hi > lo) {
            int sum = numbers[lo] + numbers[hi];
            if (sum < k) {
                lo++;
            } else if (sum > k) {
                hi--;
            } else {
                res[0] = lo + 1;
                res[1] = hi + 1;
                break;
            }
        }
        
        return res;
    }
}