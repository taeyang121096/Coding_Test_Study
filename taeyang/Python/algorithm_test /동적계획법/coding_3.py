'''계단오르기'''

import sys

def dfs(n):

    if dy[n] > 0:
        return dy[n]
    if n == 1 or n == 2:
        return n
    else:
        dy[n] = dfs(n-1)+dfs(n-2)
        return dy[n]


n = int(sys.stdin.readline())
dy = [0]*(n+1)


print(dfs(n))