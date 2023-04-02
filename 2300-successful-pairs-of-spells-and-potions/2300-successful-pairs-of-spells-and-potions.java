class Solution {
    int VAL = 0;
    int IDX = 1;
    public int[] successfulPairs(int[] s, int[] p, long success) {
        int n = s.length;
        int m = p.length;
        
        int [][] spells = new int [n][2];
        int [][] potions = new int [m][2];
        for (int i = 0; i < n; i++) {
            spells[i][VAL] = s[i];
            spells[i][IDX] = i;
        }
        
        for (int i = 0; i < m; i++) {
            potions[i][VAL] = p[i];
            potions[i][IDX] = i;
        }
        
        Arrays.sort(spells, (a, b) -> a[VAL] - b[VAL]);
        Arrays.sort(potions, (a, b) -> a[VAL] - b[VAL]);
        
        int [] res = new int [n];
        int pdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            long spell = spells[i][VAL];
            while (pdx < m && potions[pdx][VAL] * spell < success) {
                pdx++;
            }
            
            res[spells[i][IDX]] = m - pdx;
        }
        
        return res;
    }
}