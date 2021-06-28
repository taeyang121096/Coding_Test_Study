import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
lst = [i for i in range(1, n+1)]

for i in list(combinations(lst, m)):
    print(" ".join(map(str, i)))
