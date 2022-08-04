class Solution {
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        int lcm = (p * q) / gcd;
        
        if ((lcm / p) % 2 == 0)
            return 0;
        else
            return (lcm / q) % 2 == 0 ? 2 : 1;
    }
    
    public int gcd(int a, int b) {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}