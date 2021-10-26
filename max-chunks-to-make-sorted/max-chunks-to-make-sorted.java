class Solution {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            valToIndex.put(arr[i], i);
        
        int chunks = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++)
        {
            // Increasing the maxIndex we need to go to
            if (valToIndex.get(i) > maxIndex)
            {
                maxIndex = valToIndex.get(i);
            }
            else if (i == maxIndex)
            {
                chunks += 1;
                maxIndex = i + 1;
            }
        }
        
        return chunks;
    }
}