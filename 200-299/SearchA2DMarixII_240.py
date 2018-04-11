class Solution(object):
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
            return False
        m = len(matrix)
        n = len(matrix[0])
        col = n - 1
        line = 0
        while col >= 0 and line < m:
            if matrix[line][col] < target:
                line += 1
            elif matrix[line][col] == target:
                return True
            else:
                col -= 1
        return False
