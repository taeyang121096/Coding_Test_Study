'''뮤직비디오(결정 알고리즘)'''

import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
num = list(map(int, sys.stdin.readline().rstrip().split(' ')))
answer = []
lt, rt = 1, sum(num)

while lt <= rt:
    val = 0
    ans = [0]
    half = (lt+rt)//2

    for i in range(n):
        if val + num[i] <= half:
            val += num[i]
        else:
            ans.append(i)
            val = num[i]
    if len(ans) <= m :
        answer.append(half)
        rt = half -1
    else:
        lt = half + 1
print(min(answer))