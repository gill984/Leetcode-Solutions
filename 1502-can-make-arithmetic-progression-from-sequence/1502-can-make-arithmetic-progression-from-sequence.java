class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        
        for (int i : arr) {
            if (i < min) {
                second = min;
                min = i;
            } else if (i < second) {
                second = i;
            }
            set.add(i);
        }

        int diff = second - min;
        if (diff == 0) {
            return set.size() == 1;
        }
        
        int count = 0;
        for (int i = min; count < arr.length; count++, i += diff) {
            if (!set.contains(i))
                return false;
        }
        
        return true;
    }
}