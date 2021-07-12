''' 정다면체 '''
import sys

n, m = map(int, sys.stdin.readline().split(' '))

ls = [[0 for _ in range(n+1)] for _ in range(m+1)]
ans = [0 for _ in range(n+m+1)]

for i in range(1,m+1):
    for j in range(1,n+1):
        ls[i][j] = i+j

for k in range(2,n+m+1):
    for a in ls:
        ans[k] += a.count(k)
maxsum = max(ans)
answer = []

for index, value in enumerate(ans):
    if value == maxsum:
        answer.append(index)
answer.sort()
print(' '.join(map(str,answer)))


