'''휴가 삼성 역량평가'''
import sys

def dfs(day,cost):
    global res
    if day > n:
        return
    if day == n:
        if cost > res:
            res = cost
    else:
        dfs(day+t[day],cost+c[day])
        dfs(day+1,cost)

n = int(sys.stdin.readline())

t, c= [],[]

for _ in range(n):
    time, value = map(int, sys.stdin.readline().rstrip().split(' '))
    t.append(time)
    c.append(value)
res = 0
dfs(0,0)
print(res)