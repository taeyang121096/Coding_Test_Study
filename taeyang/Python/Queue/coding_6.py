'''다리의 길이 만큼 리스트를 생성하고
   총합이 무게보다 덜 나갈 경우 다리 리스트에 넣어준다
   더 나갈 경우에는 0 을 넣어서 길이를 맞춰 준다.
'''

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = [0] * bridge_length
    while len(bridge):
        answer += 1
        bridge.pop(0)
        if truck_weights:
            if sum(bridge) + truck_weights[0] <= weight:
                bridge.append(truck_weights.pop(0))
            else:
                bridge.append(0)
    return answer




bridge_length = 100
weight = 100
truck_weights = [10,10,10,10,10,10,10,10,10,10]

print(solution(bridge_length, weight, truck_weights))