class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [sys.maxsize for _ in range(0, days[-1] + 1)]
        for idx, day in enumerate(days):
            prev_cost = dp[days[idx - 1]] if idx > 0 else 0
            dp[day] = min(dp[day], prev_cost + costs[0])
            for j in range(day, min(day + 7, len(dp))):
                dp[j] = min(dp[j], prev_cost + costs[1])
            for j in range(day, min(day + 30, len(dp))):
                dp[j] = min(dp[j], prev_cost + costs[2])
        
        return dp[-1];
        