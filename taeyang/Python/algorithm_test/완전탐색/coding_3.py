'''부분집합 구하기(DFS)'''

import sys

def dfs(level,tmp):

    if level == n:
        if tmp:
            tmp = list(map(str,tmp))
            ans.append(tmp)
        return
    dfs(level+1,tmp+[level+1])
    dfs(level+1,tmp)



n = int(sys.stdin.readline())
ans,tmp = [],[]
dfs(0,tmp)
for i in ans:
    print(' '.join(i))
