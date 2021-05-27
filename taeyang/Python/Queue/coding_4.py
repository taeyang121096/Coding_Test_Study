import sys

def solution(progresses, speeds):
    answer = []

    count = 0
    while len(progresses) > 0:
        size = len(progresses)
        for i in range(size):
            progresses[i] += speeds[i]
        if progresses[0] >= 100 :
            for j in progresses:
                if j >= 100 :
                    count +=1
                else:
                    break
            answer.append(count)
            while count > 0:
                progresses.pop(0)
                speeds.pop(0)
                count -= 1

    return answer

progresses = [93, 30, 55]
speeds = [1, 30, 5]

print(solution(progresses, speeds))