class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i + 1] - arr[i] < min)
            {
                res.clear();
                min = arr[i + 1] - arr[i];
                res.add(List.of(arr[i], arr[i + 1]));
            }
            else if (arr[i + 1] - arr[i] == min)
            {
                res.add(List.of(arr[i], arr[i + 1]));
            }
        }
        
        return res;
    }
}