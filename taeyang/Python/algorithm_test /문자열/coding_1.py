''' 회문 문자열 검사'''
import sys

n = int(sys.stdin.readline())
ls = []
for _ in range(n):
    ls.append((sys.stdin.readline().strip()).lower())
cnt = 1
for i in ls:
    l, r = 0, len(i)-1
    flag = True
    while(l < r):
        if i[l] == i[r]:
            l += 1
            r -= 1
        else:
            flag = False
            break
    if flag:
        print("#%d %s" %(cnt,'Yes'))
    else:
        print("#%d %s" %(cnt,'No'))
    cnt += 1

