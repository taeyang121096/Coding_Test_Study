''' 프로그래머스 N으로 표현'''

def solution(N, number):
    answer = 0
    '''index 값 맞춰 주기위해서 0 추가'''
    num = [0,[N]]
    if number == N:
        return 1
    for i in range(2,9):
        case = []
        first = int(str(N)*i)
        case.append(first)
        ''' 2 = 1 + 1, 3 = 1 + 2, 4 = 1 + 3, 2 + 2, 5 = 1 + 4, 2 + 3 이렇게 조합이 되어진다'''
        for j in range(1, i//2+1):
            for a in num[j]:
                for b in num[i-j]:
                    case.append(a+b)
                    case.append(a-b)
                    case.append(b-a)
                    case.append(a*b)
                    if a != 0:
                        case.append(b/a)
                    if b != 0:
                        case.append(a/b)
        ''' 각각의 케이스에 값이 있는경우 그 경우의 수를 리턴 해준다'''
        if number in case:
            return i
        num.append(case)
    answer = -1
    return answer




N = 5
number = 12

print(solution(N, number))