'''백준 1966 번'''
import sys
from collections import deque

num = int(sys.stdin.readline())
ans = []
for _ in range(num):
    N, M = map(int, sys.stdin.readline().rstrip().split())
    ls = list(map(int, sys.stdin.readline().rstrip().split()))

    count = 0
    while ls:
        max_val = max(ls)
        ls = deque(ls)
        flag = True
        while True:
            if ls[0] == max_val:
                count += 1
                ls.popleft()
                if M:
                    M -= 1
                    flag = False
                break
            else:
                M -= 1
                ls.rotate(-1)
                if M < 0:
                    M = len(ls) -1
        if M == 0 and flag:
            break

    ans.append(count)

for i in ans:
    print(i)