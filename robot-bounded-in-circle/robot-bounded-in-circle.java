class Solution {
    public boolean isRobotBounded(String instructions) {
        // Naive idea, run instructions and if we come back to the same area on the same instruction
        // if we do then there is a circle, if not then we don't
        // Are we guaranteed to do it in 4 iterations of the instructions?
        // Seems like yes since from any starting facing direction we can end at one of 3 directions and
        // a given starting direction will always end with a given end direction
        
        // Up, Right, Down, Left
        int [][] dirs = new int [][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int ROW_IDX = 0;
        int COL_IDX = 1;
        
        // Run this at most 4 times, if no repeat, we don't have a cycle
        int MAX_CYCLES = 4;
        int NUM_DIRS = 4;
        char [] instructionChars = instructions.toCharArray();
        
        // 0 orientation is up, 1 is right, 2 is down, 3 is left
        // if we see an L, it's orientation -= 1, R is orientation += 1
        // G means we increment coordinates based on orientation by looking into the dirs array
        int orientation = 0;
        int row = 0;
        int col = 0;
        
        // Do first iteration
        for (int k = 0; k < instructionChars.length; k++)
        {
            char c = instructionChars[k];
            if (c == 'G')
            {
                row += dirs[orientation][ROW_IDX];
                col += dirs[orientation][COL_IDX];
            }
            else if (c == 'L')
                orientation = Math.floorMod(orientation - 1, NUM_DIRS);
            else if (c == 'R')
                orientation = Math.floorMod(orientation + 1, NUM_DIRS);
        }

        // If we're back at the origin, we're good
        if (row == 0 && col == 0)
        {
            return true;
        }
        else if (orientation == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
        // else if (orientation == 2)
        // {
        //     // We started up now we're facing down, we're going to go straight back where we started
        //     return true;
        // }
//         else if (orientation == 1)
//         {
//             // We are facing to the right, our row position is going to change by -col and col position by -row
//             int tempRow = row;
//             row -= col;
//             col -= tempRow;
//             orientation = 2;
//
//         }
    }
}