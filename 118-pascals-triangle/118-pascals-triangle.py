class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        res = [[1]]
        for i in range(1, numRows):
            row = [0 for _ in range(i + 1)]
            row[0], row[-1] = 1, 1
            for j in range(1, i):
                row[j] = (res[i-1][j] + res[i-1][j-1])
            res.append(row)
        return res