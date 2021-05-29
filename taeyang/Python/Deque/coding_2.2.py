import sys
from collections import deque
''' 덱을 사용해서 돌린다.
    1021 백준 회전하는 큐
'''
N, M = map(int, sys.stdin.readline().rstrip().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))

count = 0
deque = deque([i for i in range(1, N+1)])

for i in num:
    while True:
        if i == deque[0]:
            deque.popleft()
            break
        else:
            if len(deque) % 2 == 0:
                if deque.index(i) < len(deque) / 2 :
                    count += 1
                    deque.rotate(-1)
                else:
                    count += 1
                    deque.rotate(1)
            else:
                if deque.index(i) < len(deque) / 2:
                    count += 1
                    deque.rotate(-1)
                else :
                    count += 1
                    deque.rotate(1)

print(count)

