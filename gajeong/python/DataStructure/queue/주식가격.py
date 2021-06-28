# bruteforce

def solution(prices):
    answer = []

    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
                answer.append(j-i)
                break
            if j == len(prices)-1:
                answer.append(j-i)
        if i == len(prices)-1:
            answer.append(0)
    return answer
