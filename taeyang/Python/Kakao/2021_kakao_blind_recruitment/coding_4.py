''' 프로그래머스 합승 택시 요금'''

import sys
import heapq


def solution(n, s, a, b, fares):
    global graph, length
    answer = sys.maxsize
    graph = [[] for _ in range(n + 1)]
    length = n
    for i, j, cost in fares:
        graph[i].append([j, cost])
        graph[j].append([i, cost])

    for i in range(1, n + 1):
        answer = min(answer, dijkstra(s, i) + dijkstra(i, a) + dijkstra(i, b))

    return answer

''' 최소비용의 최단 거리는 다익스트라 알고리즘 을 사용한다 -> bfs 알고리즘과 같이 사용한다.'''
def dijkstra(s, e):
    visit = [sys.maxsize for _ in range(length + 1)]
    visit[s] = 0
    queue = [[0, s]]

    heapq.heapify(queue)

    while queue:

        cost, node = heapq.heappop(queue)

        if cost > visit[node]:
            continue

        for i in graph[node]:
            newcost, newnode = i[1], i[0]

            newcost += cost

            if newcost < visit[newnode]:
                visit[newnode] = newcost
                heapq.heappush(queue, [newcost, newnode])
    return visit[e]













