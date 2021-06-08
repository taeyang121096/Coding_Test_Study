import sys

''' 백준 15651번'''

N, M = map(int, sys.stdin.readline().rstrip().split())
temp = []
def back_tracking():
    if len(temp) == M:
        return print(' '.join(map(str,temp)))

    for i in range(1,N+1):
        temp.append(i)
        back_tracking()
        temp.pop()

back_tracking()

