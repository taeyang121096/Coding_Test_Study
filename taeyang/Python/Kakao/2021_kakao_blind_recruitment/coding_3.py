'''프로그래머스 순위 검색'''
''' 정확도 테스트는 통과 한 코드'''
'''
def solution(info, query):
    ls = []
    condition = []

    for i in info:
        ls.append(i.split(' '))

    for i in query:
        condition.append(i.split(' '))

    answer = [0 for _ in range(len(query))]

    for person in ls:
        count = 0
        for command in condition:
            index = 0
            for cond in command:
                if cond in ('and', '-'):
                    if cond == '-':
                        index += 1
                    continue
                if index == 4:
                    if eval(person[index]) >= eval(cond):
                        index += 1
                        continue
                if person[index] == cond:
                    index += 1
                    continue
                else:
                    break
            if index == 5:
                answer[count] += 1
                count += 1
            else:
                count += 1

    return answer
'''
''' 효율성 문제 모든 경우의 수를 미리 뽑아서 검사 해준다'''
from itertools import combinations


def solution(info, query):
    answer = []
    cases = dict()

    for i in info:
        temp = []
        temp.extend(i.split(' '))
        key = temp[:-1]
        value = int(temp[-1])

        for j in range(5):
            ls = list(combinations(key, j))
            for k in ls:
                keys = ''.join(k)
                if keys not in cases:
                    cases[keys] = [value]
                else:
                    cases[keys].append(value)
    for i in cases.values():
        i.sort()
    for i in query:
        ls = i.split(' ')
        key = ls[0] + ls[2] + ls[4] + ls[6]
        value = int(ls[-1])
        if '-' in key:
            key = key.replace('-', '')
        if key in cases:
            values = cases[key]
            if len(values) > 0:
                start, end = 0, len(values)

                while start < end:
                    mid = (start + end) // 2
                    if value <= values[mid]:
                        end = mid
                    else:
                        start = mid + 1
                answer.append(len(values) - start)
        else:
            answer.append(0)

    return answer

info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
