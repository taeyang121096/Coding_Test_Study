''' K 번째 수'''
import sys


T = int(sys.stdin.readline())

for t in range(T):
    n, s, e, k = map(int, sys.stdin.readline().split(' '))
    num = list(map(int, sys.stdin.readline().split(' ')))
    num = num[s-1:e]
    num.sort()
    print("#%d %d" %(t+1,num[k-1]))

