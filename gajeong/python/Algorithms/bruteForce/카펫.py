import math


def solution(brown, yellow):
    answer = [(1, yellow)]
    for i in range(2, int(math.sqrt(yellow))+1):
        if yellow % i == 0:
            answer.append((i, yellow//i))
    for num in answer:
        s = 0
        s = num[0]*2 + num[1]*2 + 4
        if s == brown:
            return [num[1]+2, num[0]+2]


brown = 24
yellow = 24
print(solution(brown, yellow))
