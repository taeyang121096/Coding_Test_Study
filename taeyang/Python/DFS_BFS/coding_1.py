''' 백준 1260'''
import sys
from collections import deque

''' 입력 받는 부분!!'''
N, M, V = map(int, sys.stdin.readline().rstrip().split())
''' 그래프 생성 '''
graph = dict()

''' visit 리스트'''
visit = [0 for _ in range(N+1)]

'''bfs 위한 queue 생성'''
queue = deque([])
''' 정답 '''
ans_bfs = []
ans_dfs = []

''' 노드들의 간선 연결 시키기 '''
for _ in range(M):
    first, second = map(int, sys.stdin.readline().rstrip().split())
    if first not in graph:
        graph[first] = [second]
    else:
        graph[first].append(second)
    if second not in graph:
        graph[second] = [first]
    else:
        graph[second].append(first)



def dfs(start, graph):
    '''아주 빡치는 예외입니다... start한 정점이 아무 정점과 연결 안된 경우...'''
    if start not in graph:
        return ans_dfs.append(start)
    '''방문 등록 bfs 부터 했으므로 1-> 0으로 등록'''
    visit[start] = 0
    ans_dfs.append(start)
    ''' 그래프의 노드들을 정렬 해줘야 한다!! 가장 작은 값 부터 들어가기 위해서'''
    graph[start].sort()
    for node in graph[start]:
        ''' visit 이 1로 초기화 되있음'''
        if visit[node]:
            dfs(node, graph)




''' start 시작 정점 '''
def bfs(start, graph):
    '''아주 빡치는 예외입니다... start한 정점이 아무 정점과 연결 안된 경우...'''
    if start not in graph:
        return ans_bfs.append(start)
    ''' 방문 등록 '''
    if not visit[start]:
        visit[start] = 1

    ''' root 노드 넣어주기'''
    queue.append(start)

    while queue:
        ''' 우선 순위 노드 들 부터 빼내준다'''
        node = queue.popleft()
        ans_bfs.append(node)
        ''' 그래프의 노드들을 정렬 해줘야 한다!! 가장 작은 값 부터 들어가기 위해서'''
        graph[node].sort()
        for i in graph[node]:
            if not visit[i]:
                visit[i] = 1
                queue.append(i)


bfs(V,graph)
dfs(V,graph)

print(' '.join(map(str,ans_dfs)))
print(' '.join(map(str,ans_bfs)))






