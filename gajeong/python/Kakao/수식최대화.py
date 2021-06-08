from itertools import permutations


def solution(expression):
    answer = []
    op2 = []
    numbers = []
    data = ''
    for i in expression:
        if i in ('+', '-', '*'):
            numbers.append(data)
            op2.append(i)
            data = ''
        else:
            data += i
    numbers.append(data)

    order = set(op2)
    order = list(permutations(order))
    numbers = list(map(int, numbers))

    # 연산자 우선순위 리스트 순서대로 반복
    for operation in order:
        nums = numbers.copy()
        op = op2.copy()
        # 우선순위 리스트 내 연산자 우선순위 대로 반복
        for operate in operation:
            for idx, data in enumerate(op):
                if data == operate:
                    if len(op) == 1:
                        print(op)
                        print(nums)
                        if op[0] == '*':
                            nums[0] * nums[1]
                        elif op[0] == '+':
                            nums[0] += nums[1]
                        elif op[0] == '-':
                            nums[0] -= nums[1]
                        print(nums[0])
                        break
                    if operate == '*':
                        nums[idx] *= nums[idx+1]
                        del nums[idx+1]
                        del op[idx]
                    elif operate == '+':
                        nums[idx] += nums[idx+1]
                        del nums[idx+1]
                        del op[idx]
                    elif operate == '-':
                        nums[idx] -= nums[idx+1]
                        del nums[idx+1]
                        del op[idx]
        if op[0] == "-":
            nums[0] -= nums[1]

        answer.append(abs(nums[0]))

    answer = max(answer)

    return answer


expression = "100-200*300-500+20"
print(solution(expression))
