'''최대 부분 증가수열'''

import sys

n = int(sys.stdin.readline())
num = list(map(int,sys.stdin.readline().rstrip().split(' ')))
num.insert(0,0)
dy = [0]*(n+1)
dy[1] = 1
ans = 0

for i in range(2, n+1):
    maxval = 0
    for j in range(i-1, 0,-1):
        if num[j] < num[i] and dy[j] > maxval:
            maxval = dy[j]

    dy[i] = maxval+1
    if dy[i] > ans:
        ans = dy[i]
print(ans)




