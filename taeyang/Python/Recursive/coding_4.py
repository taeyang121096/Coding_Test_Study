import sys
''' 11729번 하노이탑 '''

n = int(sys.stdin.readline())

def hanoi(n, a, c, b):
    ''' 하나만 있으므로 목적지로 가야 된다'''
    if n == 1:
        print(a, c)
        return
    # 제일 큰 원판 제외하고 대기열로 가야하낟
    hanoi(n-1, a, b, c)
    # 제일 큰 원판은 목적지로 이동
    print(a, c)
    # 가운데 원반을 목적지로 이동
    hanoi(n-1, b, c, a)
print(2**n-1)
hanoi(n,1,3,2)


