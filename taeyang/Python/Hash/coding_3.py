from itertools import product
''' product를 사용할려고 했는데 일단 중복 순열이라는 것을 알았지만
    막상 사용할 방법이 없어서 중복 순열 방식의 수학적 접근으로 해결함
'''

def solution(clothes):
    answer = 1
    '''가지수 딕셔너리'''
    number = dict()
    for i in clothes:
        if i[-1] in number:
            number[i[-1]] += 1
        else:
            number[i[-1]] = 1
    ''' 수학적 접근 중복 순열'''
    for i in number.values():
        answer *= (i+1)
    ''' 다 벗었을 경우는 빼줘야 한다 0,0'''
    answer -= 1



    return answer



clothes = [
           ["yellowhat", "headgear"],
           ["bluesunglasses", "eyewear"],
           ["green_turban", "headgear"]
           ]
solution(clothes)