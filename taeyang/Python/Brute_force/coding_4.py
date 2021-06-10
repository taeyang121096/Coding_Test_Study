''' 프로그래머스 소수 찾기 '''
from itertools import permutations
def solution(numbers):
    answer = 0
    temp = []
    num =[]
    ans = []
    flag = False
    for i in numbers:
        temp.append(i)
    size = len(temp)


    for i in range(1, size+1):
        num.append(list(permutations(temp,i)))
    for i in num:
        for j in i:
            tmp = int(''.join(j))
            if tmp < 2:
                continue
            for k in range(2, tmp):
                if tmp % k == 0:
                    flag = True
                    break
            if not flag:
                if tmp not in ans:
                    ans.append(tmp)
            flag = False

    answer = len(ans)
    return answer


numbers = '22'

print(solution(numbers))