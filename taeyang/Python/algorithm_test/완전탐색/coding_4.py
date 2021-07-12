'''합이 같은 부분집합 dfs'''

import sys
'''
def dfs(level):
    global ans
    if level == n:
        sum1,sum2=0,0
        for i in range(n):
            if check[i] == 1:
                sum1 += num[i]
            else:
                sum2 += num[i]
        if sum1 == sum2:
            ans = 'YES'
            sys.exit(0)
        return


    check[level] = 1
    dfs(level+1)
    check[level] = 2
    dfs(level+1)
'''
def dfs(l,sum):
    if sum > total//2:
        return
    if l == n:
        if sum == total - sum:
            print('YES')
            sys.exit(0)
    else:
        dfs(l+1,sum+num[l])
        dfs(l+1,sum)



n = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().rstrip().split(' ')))
total = sum(num)
dfs(0,0)
print('NO')