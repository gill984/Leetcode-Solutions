class Solution
{
    public int minDistance(String word1, String word2)
    {
        // Use a DP solution
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;

        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = j;

        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++)
                // First case is where character i matches character j, no edit needed
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else
                    // Second case is where an edit is needed, either insert, delete, or modify
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));

        return dp[word1.length()][word2.length()];
    }
}