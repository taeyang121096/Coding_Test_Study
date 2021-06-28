n = int(input())
answer = []
stack = []
result = True

number = 1
for i in range(1, n+1):
    data = int(input())
    while number <= data:
        stack.append(number)
        number += 1
        answer.append('+')
    if stack[-1] == data:
        stack.pop()
        answer.append('-')
    else:
        result = False
if result:
    print('\n'.join(answer))
else:
    print('NO')
