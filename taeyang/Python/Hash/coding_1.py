''' 프로그래머스 완주하지 못한 선수

'''

def solution(participant, completion):
    answer = ''

    maraton = dict()
    '''참가자들을 계속해서 추가해준다 (key : 참가자 이름 value : 명수(동명이인이 있을 수도 있기 때문)'''
    for i in participant:
        if i in maraton:
            maraton[i] += 1
        else:
            maraton[i] = 1
    '''완주자 넣고'''

    for j in completion:
        if maraton[j] == 1:
            del maraton[j]
        else:
            maraton[j] -= 1
    answer = list(maraton.keys())[0]
    return answer