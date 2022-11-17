class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // find horizontal intersection
        int area = Math.abs((ay2 - ay1) * (ax2 - ax1)) + Math.abs((bx2 - bx1) * (by2 - by1));
        int horInter = 0;
        if (ax1 <= bx1 && ax2 >= bx1)
        {
            if (ax2 <= bx2)
                horInter = Math.abs(ax2 - bx1);
            else
                horInter = Math.abs(bx2 - bx1);
        }  
        else if (bx1 <= ax1 && bx2 >= ax1)
        {
            if (bx2 <= ax2)
                horInter = Math.abs(bx2 - ax1);
            else
                horInter = Math.abs(ax2 - ax1);
        }
            
        
        if (horInter > 0)
        {
            int vertInter = 0;
            if (ay1 <= by1 && ay2 >= by1)
            {
                if (ay2 <= by2)
                    vertInter = Math.abs(ay2 - by1);
                else
                    vertInter = Math.abs(by2 - by1);
            }  
            else if (by1 <= ay1 && by2 >= ay1)
            {
                if (by2 <= ay2)
                    vertInter = Math.abs(by2 - ay1);
                else
                    vertInter = Math.abs(ay2 - ay1);
            }
            
            area -= (horInter * vertInter);
        }
        return area;
    }
}