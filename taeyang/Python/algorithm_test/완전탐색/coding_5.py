''' ??? ?? (dfs)'''
import sys


def dfs(level, tot):
    global ans
    if level == n:
        if tot > ans:
            ans = tot
        return
    if ans > tot + sum(weight[level:]):
        return
    if tot + weight[level] > c:
        return

    dfs(level+1,tot+weight[level])
    dfs(level+1,tot)


c, n = map(int, sys.stdin.readline().rstrip().split(' '))
weight = []
ans = 0
for _ in range(n):
    weight.append(int(sys.stdin.readline()))

dfs(0, 0)
print(ans)
