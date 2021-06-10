from itertools import permutations
import math
# 제곱근까지만 보고 소수를 판별하는 함수


def is_prime(x):
    if x == 1 or x == 0:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        # x가 해당 수로 나누어 떨어진다면
        if x % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    check = []
    numbers = list(numbers)

    for i in range(1, len(numbers)+1):
        combi = set(permutations(numbers, i))
        for j in combi:
            t = False
            s = ''
            for i, num in enumerate(j):
                print(j)
                s += num
                if s == '0':
                    s = ''
            if s != '':
                t = is_prime(eval(s))
            if t == True:
                if eval(s) not in check:
                    check.append(eval(s))
                    answer += 1

    return answer


numbers = "00107"
print(solution(numbers))
