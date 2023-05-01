class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int s : salary) {
            sum += s;
            if (s > max)
                max = s;
            if (s < min)
                min = s;
        }
        
        sum = sum - max - min;
        return (sum / (salary.length - 2.0));
    }
}