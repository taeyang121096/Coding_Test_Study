''' 쇠막대기 '''

import sys

count = 0
s = sys.stdin.readline().rstrip()
stack = []
for i in range(len(s)):
    if s[i] == '(':
        stack.append(s[i])
    else:
        if s[i-1] == ')':
            stack.pop()
            count += 1
        else:
            stack.pop()
            count += len(stack)
print(count)