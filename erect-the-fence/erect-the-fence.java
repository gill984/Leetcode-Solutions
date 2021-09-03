class Solution {
    final int X = 0;
    final int Y = 1;
    Point P0;
    
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3)
            return trees;
        
        // This problem is basically asking to find the convex hull
        // I don't know the algorithm for this
        int pdx = 0;
        P0 = new Point(trees[pdx][X], trees[pdx][Y]);
        Point[] points = new Point[trees.length - 1];
        for (int i = 1; i < trees.length; i++)
        {
            Point p = new Point(trees[i][X], trees[i][Y]);
            if (p.y < P0.y || (p.y == P0.y && p.x < P0.x))
            {
                points[i - 1] = P0;
                P0 = p;
            }
            else
            {
                points[i - 1] = p;
            }
        }
        
        // Sort in CCW order
        Arrays.sort(points);
        System.out.println("P0: " + P0);
        System.out.println(Arrays.toString(points));
        
        int colinear = points.length - 2;
        while (colinear >= 0 && ccw(P0, points[colinear + 1], points[colinear]) == 0)
            colinear--;
        for (int i = colinear + 1, j = points.length - 1; i < j; i++, j--)
        {
            // Swap order of colinear ending points
            Point temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }
        
        System.out.println(Arrays.toString(points));
        
        
        Point[] stack = new Point[points.length + 1];
        int idx = 0;
        stack[idx++] = P0;
        stack[idx++] = points[0];
        stack[idx++] = points[1];
        for (int i = 2; i < points.length; i++)
        {
            while (ccw(stack[idx - 2], stack[idx - 1], points[i]) < 0)
            {
                idx -= 1;
            }
            
            stack[idx++] = points[i];
            // System.out.print("Stack: ");
            // for (int j = 0; j < idx; j++)
            //     System.out.print(stack[j]);
            // System.out.println();
            // System.out.println();
        }
        
        int[][] res = new int[idx][2];
        for (int i = 0; i < idx; i++) {
            res[i][X] = stack[i].x;
            res[i][Y] = stack[i].y;
        }
            
        return res;
    }
    
    public int ccw(Point p1, Point p2, Point p3)
    {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }
    
    public int distance(Point p1, Point p2)
    {
        return (p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x);
    }
    
    class Point implements Comparable<Point>
    {
        int x;
        int y;

        public Point (int xx, int yy)
        {
            y = yy;
            x = xx;
        }

        public int compareTo(Point p)
        {
            int polar = ccw(P0, p, this);
            int dist = distance(this, P0) - distance(p, P0);        // negative if this point closer to P0 than p
            if (polar != 0)
                return polar;
            else
                return dist;
        }
        
        public String toString()
        {
            return "(" + x + "," + y +")";
        }
    }
}

