''' 수들의 합'''
import sys

n,m = map(int,sys.stdin.readline().rstrip().split(' '))
a = list(map(int, sys.stdin.readline().rstrip().split(' ')))
count = 0
lt,rt =0,1
tot = a[0]
while True:
    if tot<m:
        if rt<n:
            tot+=a[rt]
            rt+=1
        else:
            break
    elif tot == m:
        count += 1
        tot -= a[lt]
        lt += 1
    else:
        tot -= a[lt]
        lt += 1


print(count)