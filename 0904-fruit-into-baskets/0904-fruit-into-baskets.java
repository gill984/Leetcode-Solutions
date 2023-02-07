class Solution {
    public int totalFruit(int[] fruits) {
        int chainStart = 0;
        int basket1 = -1;
        int basket2 = -1;
        int res = 0;
        int lo = 0;

        for (int i = 0; i < fruits.length; i++) {
            if (basket1 != fruits[i] && basket2 != fruits[i]) {
                lo = chainStart;
                if (basket1 != fruits[chainStart])
                    basket1 = fruits[i];
                else
                    basket2 = fruits[i];
            }
            if (fruits[chainStart] != fruits[i])
                chainStart = i;
            res = Math.max(res, i - lo + 1);
        }

        return res;
    }
}