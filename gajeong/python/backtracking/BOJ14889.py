import sys
from itertools import combinations, permutations
n = int(sys.stdin.readline())
data = [list(map(int, sys.stdin.readline().rstrip().split(' ')))
        for _ in range(n)]

visit = [0]*(n)
players = [i for i in range(n)]
team = list(combinations(players, n//2))
answer = []
start_lst = team[:len(team)//2]
link_lst = team[-1:-len(team)//2-1:-1]
print(start_lst)
print(link_lst)


for i in range(len(start_lst)):
    start_player = list(permutations(start_lst[i], 2))
    link_player = list(permutations(link_lst[i], 2))
    print(start_player)
    print(link_player)
    start_force = 0
    link_force = 0

    for j in start_player:
        start_force += data[j[0]][j[1]]
    for k in link_player:
        link_force += data[k[0]][k[1]]
    answer.append(abs(start_force-link_force))

print(min(answer))
