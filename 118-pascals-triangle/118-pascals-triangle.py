class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        res = [[1]]
        for i in range(1, numRows):
            row = [res[i-1][0]]
            for j in range(1, i):
                row.append(res[i-1][j] + res[i-1][j-1])
            row.append(res[i-1][-1])
            res.append(row)
        return res