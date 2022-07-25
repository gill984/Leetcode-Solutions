class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        lo = 0
        hi = n - 1
        left = -1
        right = -1
        
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] >= target:
                if nums[mid] == target:
                    left = mid
                hi = mid - 1
            else:
                lo = mid + 1
                
        lo = 0 if left == -1 else left
        hi = n - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] <= target:
                if nums[mid] == target:
                    right = mid
                lo = mid + 1
            else:
                hi = mid - 1
                
        return [left, right]