''' 백준 14888 '''
import sys


N = int(sys.stdin.readline())
num = list(map(int,sys.stdin.readline().rstrip().split()))
oper = list(map(int,sys.stdin.readline().rstrip().split()))
'''[+,-,*,/]'''

max_val = -10**9
min_val = 10**9

def calc(count, sum):
    global max_val, min_val

    if count == N:
        max_val = max(max_val, sum)
        min_val = min(min_val, sum)

    if oper[0] > 0:
        oper[0] -= 1
        calc(count + 1, sum + num[count])
        oper[0] += 1
    if oper[1] > 0:
        oper[1] -= 1
        calc(count + 1, sum - num[count])
        oper[1] += 1
    if oper[2] > 0:
        oper[2] -= 1
        calc(count + 1, sum * num[count])
        oper[2] += 1
    if oper[3] > 0:
        oper[3] -= 1
        if sum < 0:
            rs = abs(sum) // num[count]
            rs = -rs
        else:
            rs = sum // num[count]
        calc(count + 1, rs)
        oper[3] += 1

calc(1, num[0])
print(max_val)
print(min_val)
