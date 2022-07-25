class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Binary search for both the left and right elements individually
        lo = 0
        hi = len(nums) - 1
        left = -1
        right = -1
        
        # Search for left
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] >= target:
                if nums[mid] == target:
                    left = mid
                hi = mid - 1
            else:
                lo = mid + 1
                
        # Search for right
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] <= target:
                if nums[mid] == target:
                    right = mid
                lo = mid + 1
            else:
                hi = mid - 1
                
        return [left, right]
        