class Solution {
    public int fixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == i)
            {
                return i;
            }
            else if (arr[i] > i)
            {
                i = arr[i] + 1;
            }
        }
        return -1;
    }
}