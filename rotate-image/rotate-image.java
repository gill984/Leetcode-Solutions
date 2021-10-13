class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] groups = new int [][] {{0, 0}, {0, n - 1}, {n - 1, n - 1}, {n - 1, 0}};
        int [][] groupIncrement = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int [][] layerIncrement = new int [][] {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        int layers = n / 2;
        
        for (int l = 0; l < layers; l++)
        {
            int groupCountAtLayer = n - 1 - (l * 2);
            for (int i = 0; i < groupCountAtLayer; i++)
            {
                Integer prev = null;
                for (int j = 0; j < 4; j++)
                {
                    int row = groups[j][0] + (groupIncrement[j][0] * i) + (layerIncrement[j][0] * l);
                    int col = groups[j][1] + (groupIncrement[j][1] * i) + (layerIncrement[j][1] * l);
                    int temp = matrix[row][col];
                    if (prev != null)
                        matrix[row][col] = prev;
                    prev = temp;
                }
                
                if (prev != null)
                {
                    int row = groups[0][0] + (groupIncrement[0][0] * i) + (layerIncrement[0][0] * l);
                    int col = groups[0][1] + (groupIncrement[0][1] * i) + (layerIncrement[0][1] * l);
                    matrix[row][col] = prev;
                }
            }
        }
    }
}