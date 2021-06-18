'''프로그래머스 네트워크 '''
from collections import deque


def solution(n, computers):
    answer = 0
    net = dict()
    queue = deque([])
    visit = [0 for _ in range(n)]
    for i in range(len(computers)):
        for j in range(len(computers)):
            if computers[i][j]:
                if i not in net :
                    net[i] = [j]
                else:
                    net[i].append(j)
    print(net)

    def bfs(start,net):
        nonlocal answer, visit
        if not visit[start]:
            visit[start] = 1
        queue.append(start)
        while queue:
            root = queue.popleft()
            for i in net[root]:
                if not visit[i]:
                    visit[i] = 1
                    queue.append(i)
        answer += 1
        if not min(visit):
            for i in range(len(visit)):
                if not visit[i]:
                    bfs(i,net)

    bfs(0,net)
    return answer




n = 3

computers =[[1, 1, 0], [1, 1, 1], [0, 1, 1]]
print(solution(n, computers))