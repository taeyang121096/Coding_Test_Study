'''프로그래머스 로또의 최고 순위와 최저 순위'''
def rank(num):
    if num % 6 == 0 and num != 0:
        return 1
    elif num % 6 == 5:
        return 2
    elif num % 6 == 4:
        return 3
    elif num % 6 == 3:
        return 4
    elif num % 6 == 2:
        return 5
    else:
        return 6
def solution(lottos, win_nums):
    answer = []
    count = 0
    joker = lottos.count(0)
    for i in lottos:
        if  i in win_nums:
            count += 1
    answer.append(rank(count+joker))
    answer.append(rank(count))
    return answer


