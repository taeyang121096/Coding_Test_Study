def solution(numbers, hand):
    answer = ''
    num = [[3,1],
           [0,0],[0,1],[0,2],
           [1,0],[1,1],[1,2],
           [2, 0], [2, 1], [2, 0],
           ]
    lhands, rhands = [3, 0], [3, 2]


    for i in numbers:
        if i == 1 or i == 4 or i ==7:
            answer += 'L'
            lhands = num[i]
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            rhands = num[i]
        else:
            lval, rval = 0, 0
            for a in range(2):
                lval += abs(lhands[a] - num[i][a])
            for b in range(2):
                rval += abs(rhands[b] - num[i][b])
            if lval == rval:
                if hand == 'right':
                    answer += 'R'
                    rhands = num[i]
                else:
                    answer += 'L'
                    lhands = num[i]
            elif lval > rval:
                answer += 'R'
                rhands = num[i]
            else:
                answer += 'L'
                lhands = num[i]
    return answer

numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = 'right'
print(solution(numbers, hand))


