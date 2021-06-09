''' 백준 14889 '''
import sys
from itertools import combinations

N = int(sys.stdin.readline())
man = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(N)]
visit = [False]*len(man)
ans = 198
combi = len(list(combinations(visit,N//2)))
cnt = 0

def ability(index, count):
    global ans, cnt
    if count == N // 2 :
        if cnt == combi//2 :
            return
        cnt += 1
        start, link = 0,0
        for i in range(N):
            for j in range(N):
                if visit[i] and visit[j]:
                    start += man[i][j]
                elif not visit[i] and not visit[j]:
                    link += man[i][j]
        if ans > abs(start-link):
            ans = abs(start - link)

    for i in range(index, N):
        if not visit[i]:
            visit[i] = True
            ability(i+1,count + 1)
            visit[i] = False

ability(0,0)
print(ans)
















