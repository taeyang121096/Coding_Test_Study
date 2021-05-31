'''스택을 사용하면 된다 전 값보다 들어오는 값이 크면 계속해서 넣어준다
   프로그래머스 주식가격 문제
'''

def solution(prices):
    answer = [0] * len(prices)
    stack = []
    ''' enumerate 사용하면 index,  value 리턴 해준다'''
    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]:
            ''' 결국 1을 넣는다는 뜻'''
            j = stack.pop()
            answer[j] = i - j
        ''' pop 안할경우 계속해서 넣어준다는 뜻'''
        stack.append(i)
    ''' 출력부분 '''
    while stack:
        k = stack.pop()
        answer[k] = len(prices) - k - 1

    return answer

prices = [1,2,3,2,3]

print(solution(prices))

