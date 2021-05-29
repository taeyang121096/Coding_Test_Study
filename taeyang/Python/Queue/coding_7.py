'''bruteforce 알고리즘 사용'''


def solution(prices):
    answer = [0]*len(prices)

    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] <= prices[j]:
                answer[i] += 1
            else:
                answer[i] += 1
                break


    return answer


prices = [3, 2, 1, 2, 1]

print(solution(prices))