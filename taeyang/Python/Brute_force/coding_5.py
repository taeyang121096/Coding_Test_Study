
''' 프로그래머스 카펫 '''
def solution(brown, yellow):
    answer = []
    count = 1
    y = yellow // count
    while True:
        row = (y + 2) * 2
        colum = count * 2

        if row + colum == brown:
            answer.append(row//2)
            answer.append(colum//2+2)
            break
        else:
            while True:
                count += 1
                if yellow % count == 0:
                    y = yellow // count
                    break
                else:
                    continue

    return answer


brown = 24
yellow = 24
print(solution(brown, yellow))