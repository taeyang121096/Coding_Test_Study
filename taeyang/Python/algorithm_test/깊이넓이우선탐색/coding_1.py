''' 최대점수 구하기 dfs'''
import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))

def dfs(l,v ,t):
    global res
    if t > m:
        return
    if l == n:
        if v > res:
            res = v
    else:
        dfs(l+1,v+value[l],t+time[l])
        dfs(l+1,v,t)

value, time = [], []

for _ in range(n):
    val, tim = map(int,sys.stdin.readline().rstrip().split(' '))
    value.append(val)
    time.append(tim)
res = 0
dfs(0,0,0)
print(res)