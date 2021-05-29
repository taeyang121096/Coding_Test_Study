'''스택을 사용하면 된다 전 값보다 들어오는 값이 크면 계속해서 넣어준다'''


def solution(prices):
    answer = [0] * len(prices)
    stack = []
    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)

    while stack:
        k = stack.pop()
        answer[k] = len(prices) - k - 1

    return answer

prices = [1,2,3,2,3]

print(solution(prices))

