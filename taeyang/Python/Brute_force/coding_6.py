''' 백준 1182'''
from itertools import combinations
import sys

N, S = map(int, sys.stdin.readline().rstrip().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))
ans = 0



for i in range(1, N+1):
    rs = list(combinations(num, i))
    for j in rs:
        sum = 0
        for k in j:
            sum += k

        if sum == S:
            ans += 1
print(ans)








