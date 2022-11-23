class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> boxes = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = board[i][j];
                if (val == '.')
                    continue;
                val -= '0';
                
                Set<Integer> row = rows.get(i);
                Set<Integer> col = cols.get(j);
                Set<Integer> box = boxes.get((i / 3) * 3 + j / 3);
                
                if (row.contains(val) || col.contains(val) || box.contains(val))
                    return false;
                
                row.add(val);
                col.add(val);
                box.add(val);
            }
        }
        
        return true;
    }
}