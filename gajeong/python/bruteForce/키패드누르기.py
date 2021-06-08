def solution(numbers, hand):
    answer = ''
    right = 10
    left = 12
    for i in numbers:
        if i in (1, 4, 7):
            answer += 'L'
            right = i
            continue
        elif i in (3, 6, 9):
            answer += 'R'
            left = i
            continue
        else:
            if i == 0:
                i = 11
            left -= 2

    return answer


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers, hand))
