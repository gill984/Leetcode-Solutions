class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        
        // For the first row r0, every other row r_i must be equal to r0
        // or the complement of r0, otherwise this is an invalid board. This is because
        // swaps will affect both rows equally. So if r0 is swapped into a valid row by arranging
        // columns, every r_i needs to also be swapped into valid rows by this same sequence of
        // transformations. In other words, there should only be 2 different types of rows and columns.      
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] row: board)
        {
            int rowVal = 0;
            for (int i = 0; i < n; i++)
                rowVal = rowVal | (row[i] << (n - 1 - i));
            count.put(rowVal, count.getOrDefault(rowVal, 0) + 1);
        }
        int rowSwaps = evaluate(count, n);
        
        if (rowSwaps == -1)
            return -1;
        
        count = new HashMap<>();
        for (int col = 0; col < n; col++)
        {
            int colVal = 0;
            for (int i = 0; i < n; i++)
                colVal = colVal | (board[i][col] << (n - 1 - i));
            count.put(colVal, count.getOrDefault(colVal, 0) + 1);
        }
        
        int colSwaps = evaluate(count, n);
        if (colSwaps == -1)
            return -1;
        
        return colSwaps + rowSwaps;
    }
    
    public int evaluate(Map<Integer, Integer> count, int n)
    {
        // Only 2 types of rows allowed
        if (count.size() != 2)
            return -1;
        
        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0);
        int k2 = keys.get(1);
        
        if (count.get(k1) != n/2 && count.get(k2) != n/2)
            return -1;
        else if (n % 2 == 1 && count.get(k1) != n / 2 + 1 && count.get(k2) != n / 2 + 1)
            return -1;
        
        // If lines aren't opposite
        if ((k1 ^ k2) != (1 << n) - 1)
            return -1;

        int Nones = (1 << n) - 1;
        int ones = Integer.bitCount(k1 & Nones);
        int cand = Integer.MAX_VALUE;
        if (n % 2 == 0 || ones * 2 < n) // zero start
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);

        if (n % 2 == 0 || ones * 2 > n) // ones start
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);

        return cand;
    }
}