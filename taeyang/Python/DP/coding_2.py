''' 백준 12865번'''

import sys

N, K = map(int,sys.stdin.readline().rstrip().split())
weight, value = [], []
matrix = [[0 for _ in range(K+1)] for _ in range(N+1)]

''' 모든 가중치의 값을 무게에 맞게 저장하고 비교하여 큰 값으로 바꿔 준다'''
for i in range(1, N+1):
    W,V = map(int,sys.stdin.readline().rstrip().split())
    ''' 가중치 값이 큰지 작은지 비교 해주는 부분'''
    for j in range(1,K+1):
      if j < W:
        matrix[i][j] = matrix[i-1][j]
      else:
        matrix[i][j] = max(matrix[i-1][j], matrix[i-1][j-W] + V)

print(matrix[N][K])






