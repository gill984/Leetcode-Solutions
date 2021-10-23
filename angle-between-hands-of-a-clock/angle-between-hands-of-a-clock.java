class Solution {
    public double angleClock(int hour, int minutes) {
        double mD = minutes * 6.0;
        double hD = hour * 30.0 + (minutes * 0.5);
        double res = Math.abs(hD - mD);
        if (res > 180.0)
            return 360.0 - res;
        else
            return res;
    }
}