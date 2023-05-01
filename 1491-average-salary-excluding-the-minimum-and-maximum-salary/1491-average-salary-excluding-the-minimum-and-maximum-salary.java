class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int s : salary) {
            sum += s;
            max = Math.max(s, max);
            min = Math.min(s, min);
        }
        
        return (sum - max - min) / (salary.length - 2.0);
    }
}