''' 트리의 부모 찾기 '''
from queue import Queue
import sys
n = int(sys.stdin.readline())
data = [list(map(int, sys.stdin.readline().rstrip().split(' ')))
        for i in range(n-1)]
parent = Queue()
parent.put(1)
parent_info = [0]*(n+1)
visit = [False]*(n)

while True:
    if False not in visit:
        break
    p = parent.get()
    for i in data:
        if p in i:
            # 후손 노드를 queue에 추가
            if visit[i[1-i.index(p)]-1] == True:
                continue
            else:
                parent.put(i[1-i.index(p)])
                visit[i[1-i.index(p)]-1] = True
            # 부모 정보를 parent_info의 자식 인덱스 번호에 삽입
            if parent_info[i[1-i.index(p)]] == 0:
                parent_info[i[1-i.index(p)]] = p


for i in range(2, n+1):
    print(parent_info[i])
