''' 수들의 합'''
import sys

n,m = map(int,sys.stdin.readline().rstrip().split(' '))
a = list(map(int, sys.stdin.readline().rstrip().split(' ')))
lt, rt = 0,0
count = 0
while rt < len(a):
    sumnum = 0

    for i in range(lt,rt+1):
        sumnum += a[i]
    if sumnum == m:
        count += 1
        lt += 1
        rt += 1
    elif sumnum > m:
        lt += 1
    elif sumnum < m:
        rt += 1
print(count)