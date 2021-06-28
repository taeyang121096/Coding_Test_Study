import sys
n, m = map(int, sys.stdin.readline().rstrip().split(' '))
a = []


def bak(cnt):
    if cnt == m:
        print(" ".join(map(str, a)))
        return
    for i in range(n):
        a.append(i+1)
        bak(cnt+1)
        a.pop()


bak(0)
