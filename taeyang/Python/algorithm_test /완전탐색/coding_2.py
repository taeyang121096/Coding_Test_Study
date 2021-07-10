'''이진트리 순회'''


def dfs(v):
    if v>7:
        return
    else:
        dfs(v*2)
        dfs(v*2+1)
        print(v, end=" ")
dfs(1)