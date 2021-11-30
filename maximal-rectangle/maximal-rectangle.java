class Solution {
    public int [][] lastOneDown;
    public int [][] lastOneRight;
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        lastOneDown = createLastOneDown(matrix);
        lastOneRight = createLastOneRight(matrix);

        // Debug prints
        // System.out.println("Last One Down: " + Arrays.deepToString(lastOneDown));
        // System.out.println("Last One Right: " + Arrays.deepToString(lastOneRight));

        // Find the top left corner of all the rectangle possibilities
        // Using precomputed arrays, figure out the maximum rectangle starting from this rectangle
        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '1')
                {
                    int max = 1;

                    int maxRow = lastOneDown[i][j];
                    int maxCol = lastOneRight[i][j];
                    
                    for(int c = j; c <= maxCol; c++)
                    {
                        if((maxRow - i + 1) * (maxCol - j + 1) <= globalMax ||
                          (maxRow - i + 1) * (maxCol - j + 1) <= max)
                        {
                            break;
                        }

                        maxRow = Math.min(maxRow, lastOneDown[i][c]);
                        max = Math.max(max, (c - j + 1) * (maxRow - i + 1));
                    }

                    globalMax = Math.max(max, globalMax);
                }
            }
        }

        return globalMax;
    }

    private int[][] createLastOneDown(char[][] matrix)
    {
        int [][] lastOneDown = new int[matrix.length][matrix[0].length];
        // Fill in last one up
        // value in lastOneUp[i][j] corresponds to the row which contains the last '1' character in the chain
        // of characters from this character upwards inclusive. If the character above this one
        // is a '0', then lastoneup[i][j] == i. If this cell contains a '0', lastoneup[i][j] == -1
        for(int col = 0; col < matrix[0].length; col++)
        {
            int lastOne = -1;
            for(int row = matrix.length - 1; row >= 0; row--)
            {
                if(matrix[row][col] == '0')
                {
                    lastOneDown[row][col] = -1;
                    lastOne = -1;
                }
                else
                {
                    if(lastOne == -1)
                    {
                        lastOne = row;
                    }
                    lastOneDown[row][col] = lastOne;
                }
            }
        }

        return lastOneDown;
    }

    private int[][] createLastOneRight(char[][] matrix)
    {
        int[][] lastOneRight = new int[matrix.length][matrix[0].length];

        // Populate lastOneRight
        for(int row = 0; row < matrix.length; row++)
        {
            int lastOne = -1;
            for(int col = matrix[0].length - 1; col >= 0; col--)
            {
                if(matrix[row][col] == '0')
                {
                    lastOneRight[row][col] = -1;
                    lastOne = -1;
                }
                else
                {
                    if(lastOne == -1)
                    {
                        lastOne = col;
                    }
                    lastOneRight[row][col] = lastOne;
                }
            }
        }

        return lastOneRight;
    }
}