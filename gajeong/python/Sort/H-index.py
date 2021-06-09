def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    for i, num in enumerate(citations):
        if i+1 < num:
            answer = i+1
        else:
            break
    return answer


citations = [20, 19, 18, 1]
print(solution(citations))
