# stack
# 솔직히 이해 잘 안감 다시보기
def solution(prices):
    answer = [0]*len(prices)
    stack = []
    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i-j
        stack.append(i)
    while stack:
        j = stack.pop()
        answer[j] = len(prices)-1-j

    return answer
