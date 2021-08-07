''' 회의실 배정(그리디)'''

import sys

n = int(sys.stdin.readline())
num = []
for _ in range(n):
    ls = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    num.append(ls)
num.sort(key=lambda x:(x[1],x[0]))


end = 0
cnt = 0
for s, e in num:
    if end <= s:
        end = e
        cnt += 1
print(cnt)

