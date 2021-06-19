''' 백준 3190 '''

import sys
from collections import deque

N = int(sys.stdin.readline())
queue = deque([])
cmd = dict()
''' matrix 전부다'''
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

''' 입력 부분'''
matrix = [[0 for _ in range(N)] for _ in range(N)]
K = int(sys.stdin.readline())

for _ in range(K):
    row, col = map(int, sys.stdin.readline().rstrip().split())
    matrix[row-1][col-1] = 1
L = int(sys.stdin.readline())

for _ in range(L):
    time, _, dir = sys.stdin.readline().rstrip().partition(' ')
    time = int(time)
    cmd[time] = dir

x,y = 0,0
queue.append([x,y])
direction = 1
count = 1
matrix[y][x] = -1
# 여기가 로직
while True:

    x, y = x + dx[direction], y + dy[direction]
    if 0<= x < N and 0 <= y < N and matrix[y][x] != -1:
        if not matrix[y][x]:
            tx, ty = queue.popleft()
            matrix[ty][tx] = 0
        matrix[y][x] = -1
        queue.append([x,y])
        if count in cmd:
            if cmd[count] == 'L':
                direction = (direction -1) % 4
            else:
                direction = (direction + 1) % 4
        count += 1
    else:
        break


print(count)

















