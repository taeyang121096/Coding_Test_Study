import sys
from itertools import combinations, permutations
n = int(sys.stdin.readline())
data = [list(map(int, sys.stdin.readline().rstrip().split(' ')))
        for _ in range(n)]
'''플레이어 번호 순으로 사람 정렬 n-1로 함 '''
players = [i for i in range(n)]

'''조합 사용하여 가능한 팀 구성'''
team = list(combinations(players, n//2))
answer = []

'''조합을 반으로 나누고 뒤의 반은 역순으로 저장하면 
결국 중복되지 않는 팀구성으로 정렬됨 '''
start_lst = team[:len(team)//2]
link_lst = team[-1:-len(team)//2-1:-1]

'''팀원들 간의 순열 사용하여 가능한 2차원 인덱스 간 배열 생성,, '''
for i in range(len(start_lst)):
    start_player = list(permutations(start_lst[i], 2))
    link_player = list(permutations(link_lst[i], 2))
    start_force = 0
    link_force = 0

    for j in start_player:
        start_force += data[j[0]][j[1]]
    for k in link_player:
        link_force += data[k[0]][k[1]]
    answer.append(abs(start_force-link_force))

print(min(answer))
