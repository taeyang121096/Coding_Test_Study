from itertools import combinations
''' 프로그래머스 메뉴 리뉴얼'''

def solution(orders, course):
    answer = []

    for i in course:
        case = []
        num = dict()
        ''' 모든 조합을 찾아준다 하지만 순서가 중요하므로 먼저 문자열을 sorting 한 상태에서 조합한다'''
        for j in orders:
            case.extend(list(combinations(sorted(j), i)))

        for k in case:
            order = ''.join(k)
            if order in num:
                num[order] += 1
            else:
                num[order] = 1
                ''' 가장 큰 값을 먼저 찾아서 비교 해준다'''
        for check in num:
            if num[check] == max(list(num.values())):
                if num[check] > 1:
                    answer.append(check)
    ''' 마지막으로 답을 줄때 오름 차순 정렬 한다'''
    answer.sort()

    return answer