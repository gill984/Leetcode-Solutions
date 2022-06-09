class Solution {
    public int[] twoSum(int[] numbers, int k) {
        int [] res = new int [2];
        Map<Integer, Integer> indices = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (indices.containsKey(k - num)) {
                res[0] = indices.get(k - num);
                res[1] = i + 1;
                break;
            }
            indices.put(num, i + 1);
        }
        
        return res;
    }
}