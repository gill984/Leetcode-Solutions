class Solution {
    int [] digits = new int [] {0, 1, 6, 8, 9};
    int [] reverseMap = new int [] {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

    public int confusingNumberII(int n) {
        return dfs(0, 0, 1, n);
    }

    public int dfs (int curNum, int reverseNum, int pow, int n) {
        int tempCur = curNum;
        int tempRev = reverseNum;
        int sum = 0;
        for (int digit : digits) {
            // Skip the case where adding 0s creates the same number
            if (curNum == 0 && digit == 0)
                continue;

            // 1. Try Adding This digit and check bounds
            curNum = (curNum * 10) + digit;
            reverseNum = (pow * reverseMap[digit]) + reverseNum;
            
            if (curNum > n || Integer.MAX_VALUE / 10 + digit < tempCur)
                break;

            // 2. Check if the resulting number is confusing
            if (curNum != reverseNum)
                sum++;
            
            // 3. Search by trying to add more digits
            sum += dfs(curNum, reverseNum, pow * 10, n);

            // 4. Cleanup added digit to backtrack
            reverseNum = tempRev;
            curNum = tempCur;
        }

        return sum;
    }
}