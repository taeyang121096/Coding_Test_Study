''' 두 리스트 합치기'''
import sys

n = int(sys.stdin.readline())
ls1 = list(map(int, sys.stdin.readline().rstrip().split(' ')))
m = int(sys.stdin.readline())
ls2 = list(map(int, sys.stdin.readline().rstrip().split(' ')))
ls = []
p1, p2 = 0,0
while p1 < n and p2 < m:
    if ls1[p1] <= ls2[p2]:
        ls.append(ls1[p1])
        p1 += 1
    else:
        ls.append(ls2[p2])
        p2 += 1
if p1 == n:
    ls.extend(ls2[p2:])
else:
    ls.extend(ls1[p1:])
print(ls)