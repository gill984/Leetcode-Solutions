class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.bSearch(nums, 0, len(nums) - 1, target, True), self.bSearch(nums, 0, len(nums) - 1, target, False)]
    
    def bSearch(self, nums, lo, hi, target, searchLeft):
        res = -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] > target:
                hi = mid - 1
            elif nums[mid] < target:
                lo = mid + 1
            else:
                res = mid
                if searchLeft:
                    hi = mid - 1
                else:
                    lo = mid + 1
        return res
                