class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        total = sum(candies)
        if total < k:
            return 0
        
        res = 0
        hi = total // k
        lo = 1
        while lo <= hi:
            mid = (hi + lo) // 2
            if self.attempt(candies, mid, k):
                res = max(res, mid)
                lo = mid + 1
            else:
                hi = mid - 1
        return res
        
    def attempt(self, candies, c, k):
        count = 0
        for candy in candies:
            count += candy // c
        return count >= k