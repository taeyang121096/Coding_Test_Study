''' 프로그래머스 H-index'''


def solution(citations):
    answer = 0
    citations.sort()
    count = 0
    while True:

        if max(citations) == 0:
            break

        for i in citations:
            if i >= count:
                index = citations.index(i)
                break

        if len(citations) - index >= count:
            answer = count
            count += 1
        else:
            break

    return answer