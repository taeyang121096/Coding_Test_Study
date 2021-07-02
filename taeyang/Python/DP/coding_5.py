''' 프로그래머스 등굣길'''


def solution(m, n, puddles):
    answer = 0
    matrix = [[1 for _ in range(m + 1)] for _ in range(n + 1)]

    ''' 모든 좌표를 1롤 맞춘다'''

    ''' 물웅덩이는 0으로 고쳐준다'''
    for i in puddles:
        x, y = i
        matrix[y][x] = 0

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            ''' 물웅덩이와 x,y = 1일때는 처리 해주고 나머지 경우 위 왼쪽 값을 더하여 경우의수를 만들어준다'''
            if matrix[i][j] == 0:
                continue
            if i == 1 and j == 1:
                continue
            if i == 1:
                matrix[i][j] = matrix[i][j - 1]
                continue
            if j == 1:
                matrix[i][j] = matrix[i - 1][j]
                continue

            matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]
    answer = matrix[n][m] % 1000000007

    return answer