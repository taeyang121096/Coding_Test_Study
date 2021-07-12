'''후위식 연산'''
import sys

val = sys.stdin.readline().rstrip()
stack = []
for i in val:
    if i.isdigit():
        stack.append(i)
    else:
        n2 = stack.pop()
        n1 = stack.pop()
        res = str(eval(n1+i+n2))
        stack.append(res)

print(''.join(stack))
