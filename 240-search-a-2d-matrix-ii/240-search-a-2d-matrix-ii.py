class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            if row[0] <= target and row[-1] >= target:
                idx = bisect_left(row, target)
                if row[idx] == target:
                    return True
        return False