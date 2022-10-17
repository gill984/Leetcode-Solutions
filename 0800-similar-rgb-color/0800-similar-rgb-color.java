class Solution {
    public String similarRGB(String color) {
        String minString = "";
        int minDiff = Integer.MAX_VALUE;
        int [] colors = convert(color);
        for (int i = 0; i <= 0xFF; i += 0x11) {
            for (int j = 0; j <= 0xFF; j += 0x11) {
                for (int k = 0; k <= 0xFF; k += 0x11) {
                    int diff = calcDiff(i, j, k, colors);
                    if (diff < minDiff) {
                        minDiff = diff;
                        minString = "#" + String.format("%02x", i) + String.format("%02x", j) + String.format("%02x", k);
                    }
                }
            }
        }
        return minString;
    }
    
    public int calcDiff(int a, int b, int c, int [] vals) {
        return (a - vals[0]) * (a - vals[0]) + (b - vals[1]) * (b - vals[1]) + (c - vals[2]) * (c - vals[2]);
    }
    
    public int [] convert(String color) {
        return new int [] {
            Integer.parseInt(color.substring(1, 3), 16),
            Integer.parseInt(color.substring(3, 5), 16),
            Integer.parseInt(color.substring(5, 7), 16)
        };
    }
}