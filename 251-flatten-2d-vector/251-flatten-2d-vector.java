class Vector2D {
    int [][] vec;
    int row;
    int col;
    
    public Vector2D(int[][] vec) {
        row = 0;
        col = 0;
        while (row < vec.length && col == vec[row].length) {
            row += 1;
            col = 0;
        }
        this.vec = vec;
    }
    
    public void advance () {
        
    }
    
    public int next() {
        int res = vec[row][col];
        col++;
        while (row < vec.length && col == vec[row].length) {
            row += 1;
            col = 0;
        }
        return res;
    }
    
    public boolean hasNext() {
        return row != vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */