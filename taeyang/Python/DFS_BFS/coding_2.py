'''백준 2606'''
import sys
from collections import deque

comp = int(sys.stdin.readline())
connect = int(sys.stdin.readline())

net = dict()
queue = deque([])
'''방문 기록'''
visit = [0 for _ in range(comp+1)]
'''1은 제외 하고 증가하므로 -1 부터 시작'''
count = -1

for _ in range(connect):
    first, second = map(int, sys.stdin.readline().rstrip().split())
    ''' 네트워크 연결'''
    if first not in net:
        net[first] = [second]
    else:
        net[first].append(second)
    if second not in net:
        net[second] = [first]
    else:
        net[second].append(first)

''' 큐를 사용해서 너비 우선 탐색'''
def bfs(start, visit):
    global count
    ''' 방문 등록'''
    visit[start] = 1
    queue.append(start)

    while queue:
        node = queue.popleft()
        ''' 카운트 증가 해준다 '''
        count += 1
        for i in net[node]:
            if not visit[i]:
                visit[i] = 1
                queue.append(i)
bfs(1,visit)
print(count)