import sys

''' 백준 11725 트리의 부모 찾기'''
N = int(sys.stdin.readline())

tree = {i: [] for i in range(1, N+1)}
queue = [1]
ans = [1 for i in range(N+1)]
visit = [False for i in range(N+1)]

for _ in range(N-1):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    tree[x].append(y)
    tree[y].append(x)
print(tree)

while queue:
    root = queue.pop(0)
    for i in tree[root]:
        if not visit[i]:
            visit[i] = True
            ans[i] = root
            queue.append(i)



for i in range(2,N+1):
    print(ans[i])
