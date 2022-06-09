class Solution {
    public int[] twoSum(int[] numbers, int k) {
        Map<Integer, int[]> indices = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            indices.putIfAbsent(num, new int [] {0, 0});
            if (indices.get(num)[0] == 0) {
                indices.get(num)[0] = i + 1;
            } else {
                indices.get(num)[1] = i + 1;
            }
        }
        
        int [] res = new int [2];
        for (int i : indices.keySet()) {
            if (indices.containsKey(k - i) && (k - i != i || indices.get(i)[1] != 0)) {
                res[0] = indices.get(i)[0];
                res[1] = (k - i == i ? indices.get(i)[1] : indices.get(k - i)[0]);
                break;
            }
        }
        
        if (res[0] > res[1]) {
            int swap = res[0];
            res[0] = res[1];
            res[1] = swap;
        }
        return res;
    }
}