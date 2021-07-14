'''공주 구하기(큐 자료구조)'''
import sys

n, k = map(int, sys.stdin.readline().rstrip().split(' '))
ls = [i+1 for i in range(n)]

index = 0
while len(ls) != 1:

    index += k-1
    if index >= len(ls):
        index %= len(ls)
    ls.pop(index)
print(ls[0])
