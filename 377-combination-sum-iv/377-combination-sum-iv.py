class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0 for _ in range(target + 1)]
        dp[0] = 1
        for comb in range(target + 1):
            for num in nums:
                if comb >= num:
                    dp[comb] += dp[comb - num]
        return dp[target]