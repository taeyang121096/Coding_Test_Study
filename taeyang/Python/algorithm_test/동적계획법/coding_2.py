'''네트워크 선 자르기 top down(재귀, 메모제이션)'''

import sys

n = int(sys.stdin.readline())
dy = [0 for _ in range(n+1)]


def dfs(n):

    if dy[n]>0:
        return dy[n]
    if n == 1 or n == 2:
        return n
    else:
        dy[n] = dfs(n-1) + dfs(n-2)
        return dy[n]

print(dfs(n))