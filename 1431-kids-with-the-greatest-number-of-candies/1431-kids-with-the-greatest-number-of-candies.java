class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies)
            max = Math.max(c, max);
        
        List<Boolean> res = new ArrayList<>();
        for (int c : candies) {
            res.add(c + extraCandies >= max);
        }
        return res;
    }
}