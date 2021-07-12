'''후위 표기식 만들기'''
import sys

val = sys.stdin.readline().rstrip()

stack = []
ans = ''

for i in val:
    if i.isdigit():
        ans += i
    else:
        if i =='(':
            stack.append(i)
        elif i =='*' or i =='/':
            while stack and (stack[-1]=='*' or stack[-1]=='/'):
                ans += stack.pop()
            stack.append(i)
        elif i =='+' or i=='-':
            while stack and stack[-1] !='(':
                ans += stack.pop()
            stack.append(i)
        elif i ==')':
            while stack and stack[-1] !='(':
                ans += stack.pop()
            stack.pop()
if stack:
    ans += ''.join(stack[-1::-1])
print(ans)