class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for q in range(m)]
        dp[0][0] = 1
        print(dp)
        
        for row in range(m):
            for col in range(n):
                dp[row][col] += (dp[row - 1][col] if row > 0 else 0) + (dp[row][col - 1] if col > 0 else 0)
        return dp[m - 1][n - 1]