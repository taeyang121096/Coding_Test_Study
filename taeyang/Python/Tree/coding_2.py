import sys
'''백준 1167번'''

V = int(sys.stdin.readline())
tree = [[] for _ in range(V+1)]
visit = [False for _ in range(V+1)]
ans = [0 for _ in range(V+1)]
last_node = []
queue = [1]

for _ in range(V):
    ls = list(map(int, sys.stdin.readline().rstrip().split()))
    for i in range(1, len(ls)-2, 2):
        tree[ls[0]].append((ls[i],ls[i+1]))
print(tree)
def bfs(queue):

    visit[queue[0]] = True

    while queue:
        root = queue.pop(0)
        last_node.append(root)

        for index, value in tree[root]:
            if not visit[index]:
                visit[index] = True
                ans[index] = ans[root]+value
                queue.append(index)

    print(ans)
    print(last_node)

    return ans

print(max(bfs(queue)))




