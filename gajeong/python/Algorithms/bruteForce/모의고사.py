def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    scores = [0, 0, 0]
    for num, ans in enumerate(answers):
        if p1[num % 5] == ans:
            scores[0] += 1
        if p2[num % 8] == ans:
            scores[1] += 1
        if p3[num % 10] == ans:
            scores[2] += 1
    max_score = max(scores)
    for i in range(3):
        if scores[i] == max_score:
            answer.append(i+1)
    return answer
