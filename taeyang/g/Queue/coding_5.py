


def solution(priorities, location):
    answer = 0
    size = len(priorities)
    for i in range(size):
        for j in priorities[i+1 :]:
            if j > priorities[i]:
                priorities.append(priorities.pop(i))
    print(priorities)
    return answer


priorities = [1, 2,1,4]
location = 2

print(solution(priorities, location))