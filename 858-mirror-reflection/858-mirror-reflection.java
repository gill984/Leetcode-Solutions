class Solution {
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        int lcm = (p * q) / gcd;
        
        int horizontalWall = lcm / q;
        int verticalWall = lcm / p;
        
        if (verticalWall % 2 == 0) {
            return 0;
        } else {
            return horizontalWall % 2 == 0 ? 2 : 1;
        }
    }
    
    public int gcd(int a, int b) {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}