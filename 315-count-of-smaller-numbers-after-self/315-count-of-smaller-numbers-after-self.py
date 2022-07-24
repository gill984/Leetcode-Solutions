class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        pairs = [[nums[i], i, 0] for i in range(len(nums))]
        self.mergeSort(pairs, 0, len(nums) - 1)
        res = [0] * len(nums)
        for pair in pairs:
            res[pair[1]] = pair[2]
            
        return res
        
    def mergeSort(self, pairs, lo, hi):
        
        if lo == hi:
            return [pairs[lo]]
        
        mid = (lo + hi) // 2
        left = self.mergeSort(pairs, lo, mid)
        right = self.mergeSort(pairs, mid + 1, hi)
        
        ldx = 0
        rdx = 0
        res = []
        while ldx < len(left) and rdx < len(right):
            if left[ldx][0] > right[rdx][0]:
                left[ldx][2] += len(right) - rdx
                res.append(left[ldx])
                ldx += 1
            else:
                res.append(right[rdx])
                rdx += 1
                
        while ldx < len(left):
            res.append(left[ldx])
            ldx += 1
            
        while rdx < len(right):
            res.append(right[rdx])
            rdx += 1

        return res
        
        