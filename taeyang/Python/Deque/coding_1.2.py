import sys
from collections import deque
''' deque 사용 할 경우
    10866 백준 문제 덱 구현
'''

N = int(sys.stdin.readline())

queue = []
deque = deque(queue)


for i in range(N):
    command, _, num = sys.stdin.readline().rstrip().partition(' ')

    if command == "push_front":
        deque.appendleft(num)
    elif command == "push_back":
        deque.append(num)
    elif command == "pop_front":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.popleft())
    elif command == "pop_back":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.pop())
    elif command == "size":
        print(len(deque))

    elif command == "empty":
        if len(deque) == 0:
            print(1)
        else:
            print(0)

    elif command == "front":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[0])

    else:
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[-1])





