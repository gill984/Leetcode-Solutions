class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++)
            valToIndex.put(arr2[i], i);
        int[] count = new int[arr2.length];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : arr1)
        {
            if (valToIndex.containsKey(i))
                count[valToIndex.get(i)]++;
            else
                q.offer(i);
        }
        
        int rdx = 0;
        for (int i = 0; i < arr2.length; i++)
        {
            int c = count[i];
            for (int j = 0; j < c; j++)
                arr1[rdx++] = arr2[i];
        }
        
        while (!q.isEmpty())
            arr1[rdx++] = q.poll();
        
        return arr1;
    }
}