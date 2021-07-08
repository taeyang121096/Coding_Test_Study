'''가장 큰 수'''

import sys

n, m =  map(int,sys.stdin.readline().strip().split(' '))
stack = []
n = list(map(int,str(n)))

for i in n:
    while stack and m > 0 and stack[-1] < i :
        stack.pop()
        m -= 1
    stack.append(i)
if m != 0:
    stack = stack[:-m]
print(''.join(map(str,stack)))