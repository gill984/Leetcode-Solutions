MOD = 1000000007
class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        dp = {}
        arr.sort()
        res = len(arr)
        for num in arr:
            for key in list(dp.keys()):
                target = num / key
                if num % key != 0 or target not in dp:
                    continue
                
                count = dp[key] * dp[key] if key == target else (dp[key] * dp[target])
                dp[num] = dp[num] + count if num in dp else count
                res += count
            dp[num] = dp[num] + 1 if num in dp else 1
                
        # print(dp)   
        return res % MOD