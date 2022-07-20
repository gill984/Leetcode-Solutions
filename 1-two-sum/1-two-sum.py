class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in d.keys():
                return [d[diff], i]
            d[num] = i