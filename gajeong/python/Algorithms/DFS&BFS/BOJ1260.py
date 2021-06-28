import sys
from collections import deque
def DFS(v,data,answer,visit):
  '''#조건처리'''
  if visit[v]==1:
    return
  '''#방문처리'''
  visit[v]=1
  '''#갈곳처리'''
  answer.append(v)
  for i in data[v]:
    DFS(i,data,answer,visit)
  return answer

def BFS(v,data,answer,visit):
  if visit[v]==1:
      return
  ''' #큐에 담고 방문처리'''
  queue=deque([v])
  
  visit[v]=1

  '''#큐에서 하나씩 꺼내서 갈곳처리'''
  while queue:
    v = queue.popleft()
    answer.append(v)
    for i in data[v]:
      if visit[i]!=1:
        queue.append(i)
        
        visit[i]=1
  return answer


n,m,v = map(int,sys.stdin.readline().rstrip().split(' '))
data = [[]for j in range(n+1)]
for i in range(m):
  a,b = map(int,sys.stdin.readline().rstrip().split(' '))
  data[a].append(b)
  data[b].append(a)
for i in data:
  i.sort()

visit = [0]*(n+1)
answer=[]
dfs_list = DFS(v,data,answer,visit)


answer=[]
visit = [0]*(n+1)
bfs_list = BFS(v,data,answer,visit)

for i in dfs_list:
  print(i,end=' ')
print('')
for i in bfs_list:
  print(i,end=' ')
  
