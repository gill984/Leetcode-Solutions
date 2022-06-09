class Solution {
    public int[] twoSum(int[] numbers, int k) {
        int [] res = new int [2];
        int [] indices = new int [2001];
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (k - num + 1000 < indices.length && indices[k - num + 1000] != 0) {
                res[0] = indices[k - num + 1000];
                res[1] = i + 1;
                break;
            }
            
            indices[num + 1000] = i + 1;
        }
        
        return res;
    }
}