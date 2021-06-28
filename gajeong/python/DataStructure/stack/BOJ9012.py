t = int(input())
data = [list(input()) for _ in range(t)]
answer = []

# ')'가 나오면 stack에서 pop
for lst in data:
    stack = []
    idx = 0
    for i in lst:
        if i == '(':
            stack.append(i)
        else:
            if len(stack) != 0:
                stack.pop()
            # 종료조건 stack에 아무것도 없는데 ')'이 들어오는경우
            else:
                break

        idx += 1
    # 각 리스트의 끝에 도달한 상태로, stack이 비어있을 경우만 성공
    if idx == len(lst) and len(stack) == 0:
        answer.append('YES')
    else:
        answer.append('NO')


for a in answer:
    print(a)
