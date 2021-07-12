''' 마구간 정하기'''

import sys
n,c = map(int, sys.stdin.readline().rstrip().split(' '))
ls = []
for i in range(n):
    ls.append(int(sys.stdin.readline()))
ls.sort()
val = 0
for i in range(1,len(ls)):
    val += ls[i] - ls[i-1]
ans = []
lt, rt = 1, val

while lt <=  rt:
    half = (lt+rt)//2
    count = 1
    start = ls[0]
    for i in range(1,len(ls)):
        if start + half <= ls[i]:
            count += 1
            start = ls[i]
    if count < c:
        rt = half - 1
    else:
        ans.append(half)
        lt = half + 1
print(max(ans))