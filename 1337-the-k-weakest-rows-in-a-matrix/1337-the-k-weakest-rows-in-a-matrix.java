class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // Assign each row a score, score is 101 * ones + row
        // Using a max priority queue, keep track of the k weakest
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<int[]> kWeakest = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i = 0; i < m; i++)
        {
            int s = score(mat[i], i, m, n);
            
            if (kWeakest.size() < k)
            {
                kWeakest.offer(new int [] {i, s});
            }
            else if (kWeakest.peek()[1] > s)
            {
                kWeakest.poll();
                kWeakest.offer(new int [] {i, s});
            }
        }
        
        int [] res = new int [k];
        
        for (int i = 0; i < k; i++)
        {
            res[k - 1 - i] = kWeakest.poll()[0];
        }
        
        return res;
    }
    
    public int score (int [] arr, int row, int m, int n)
    {      
        if (arr[0] == 0)
            return row;
        
        // Binary search for last 1
        int lo = 0;
        int hi = n;
        
        while (lo < hi)
        {
            int mid = (hi + lo) / 2;
            if (arr[mid] == 1)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid;
            }
        }
        // System.out.println(lo);
        return row + ((lo) * (m + 1));
    }
}