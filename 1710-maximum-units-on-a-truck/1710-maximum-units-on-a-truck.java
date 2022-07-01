class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int count = 0;
        int res = 0;
        for (int i = 0; i < n && count < truckSize; i++) {
            for (int j = 0; j < boxTypes[i][0] && count++ < truckSize; j++) {
                res += boxTypes[i][1];
                // count++;
            }
        }
        return res;
    }
}