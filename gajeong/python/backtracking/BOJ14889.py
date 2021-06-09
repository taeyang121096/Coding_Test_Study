import sys
from itertools import combinations, permutations
n = int(sys.stdin.readline())
data = [list(map(int, sys.stdin.readline().rstrip().split(' ')))
        for _ in range(n)]

visit = [0]*(n)
players = [i for i in range(n)]
team = list(combinations(players, 3))
print(team)

for i in range(len(team)//2):
    lst = list(permutations(team[i], 2))
    print(lst)
