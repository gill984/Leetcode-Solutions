class Solution {
    public int[] twoSum(int[] numbers, int k) {
        int lo = 0;
        int hi = numbers.length - 1;
        int [] res = new int [2];
        
        while (hi > lo) {
            while (numbers[lo] + numbers[hi] < k) {
                lo++;
            } 
            
            while (numbers[lo] + numbers[hi] > k) {
                hi--;
            } 
            
            if (numbers[lo] + numbers[hi] == k) {
                res[0] = lo + 1;
                res[1] = hi + 1;
                break;
            }
        }
        
        return res;
    }
}