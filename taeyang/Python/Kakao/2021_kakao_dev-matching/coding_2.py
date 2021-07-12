'''프로그래머스 행렬 테두리 회전하기'''

from collections import deque


def rotate(x1, y1, x2, y2,matrix,answer):

    ls = deque()
    for i in range(y1, y2 + 1):
        ls.append(matrix[x1][i])
    for i in range(x1 + 1, x2 + 1):
        ls.append(matrix[i][y2])
    for i in range(y2 - 1, y1 - 1, -1):
        ls.append(matrix[x2][i])
    for i in range(x2 - 1, x1, -1):
        ls.append(matrix[i][y1])

    if ls:
        answer.append(min(ls))
        ls.rotate(1)
        for i in range(y1, y2 + 1):
            matrix[x1][i] = ls.popleft()
        for i in range(x1 + 1, x2 + 1):
            matrix[i][y2] = ls.popleft()
        for i in range(y2 - 1, y1 - 1, -1):
            matrix[x2][i] = ls.popleft()
        for i in range(x2 - 1, x1, -1):
            matrix[i][y1] = ls.popleft()



def solution(rows, columns, queries):
    answer = []
    matrix = [[0 for _ in range(columns + 1)] for _ in range(rows + 1)]
    for j in range(1, rows + 1):
        for i in range(1, columns + 1):
            matrix[j][i] = i + (j - 1) * columns
    for i in queries:
        x1, y1, x2, y2 = i
        rotate(x1, y1, x2, y2,matrix,answer)
    return answer