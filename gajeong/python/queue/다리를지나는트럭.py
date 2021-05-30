# https://programmers.co.kr/learn/courses/30/lessons/42583
from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 1
    queue = deque([0]*(bridge_length-1))
    queue.append(truck_weights[0])
    finish = len(truck_weights)
    idx = 1
    s = sum(queue)
    while True:
        # 종료 조건
        if any(queue) == False:
            break
        answer += 1
        if idx >= finish:
            queue.popleft()
            continue
        # 다리가 견딜 수 있는 무게를 넘는 경우
        # if sum(queue)-queue[0]+truck_weights[idx] > weight:
        if s-queue[0]+truck_weights[idx] > weight:
            s -= queue[0]
            queue.popleft()
            queue.append(0)
            continue
        # 다리가 견딜 수 있는 무게
        else:
            s = s-queue[0]+truck_weights[idx]
            queue.popleft()
            if idx >= finish:
                queue.append(0)
            else:
                queue.append(truck_weights[idx])
            idx += 1
            continue
    return answer


print(solution(2, 10, [7, 4, 5, 6]))
