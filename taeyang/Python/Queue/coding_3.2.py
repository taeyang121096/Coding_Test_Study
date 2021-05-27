import sys
from collections import deque
''' collection deque 사용해서 만들었습니다.
    deque 는 큐의 삽입 삭제가 양방향으로 가능한 구조 입니다.
'''

N = int(sys.stdin.readline())

queue = [i for i in range(1, N+1)]
card = deque(queue)

while len(card) > 1:
    card.popleft()
    ''' rotate 함수에 음수 일 경우 왼쪽 회전 양수 일경우 오른쪽 회전'''
    card.rotate(-1)
print(card[0])


