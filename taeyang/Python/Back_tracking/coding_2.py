import sys

''' 백준 15650번'''

N, M = map(int, sys.stdin.readline().rstrip().split())
temp = []
def back_tracking():
    if len(temp) == M:
        return print(' '.join(map(str,temp)))

    for i in range(1,N+1):

        if temp:
            if temp[-1] > i:
                continue
        if i not in temp:
            temp.append(i)
            back_tracking()
            temp.pop()

back_tracking()

