''' k 번째 큰수'''
import sys
from itertools import combinations

n, k = map(int, sys.stdin.readline().split(' '))
num = list(map(int, sys.stdin.readline().split(' ')))
ls = set()
for i in combinations(num,3):
    ls.add(sum(i))
ls= sorted(ls,reverse=True)
print(ls[k-1])
