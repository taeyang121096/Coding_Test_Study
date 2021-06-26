''' 백준 9095번'''
import sys

def cal(n):
    ''' 경우의 수로 생각 해주면된다 1 = 1, 2 = 2, 3 = 4, 나머지의 경우도 위의 수들의 합으로 경우의 수를 찾을 수 있따.'''
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return cal(n-1) + cal(n-2) + cal(n-3)




T = int(sys.stdin.readline())




for _ in range(T):
    n = int(sys.stdin.readline())
    print(cal(n))

