''' 이분 검색'''
import sys

n, m = map(int,sys.stdin.readline().rstrip().split(' '))
ls = list(map(int,sys.stdin.readline().rstrip().split(' ')))
ls.sort()
lt, rt = 0, len(ls)-1

while lt <= rt:
    mid = (lt + rt) // 2

    if ls[mid] < int(m):
        lt = mid + 1
    elif ls[mid] > int(m):
        rt = mid - 1
    else:
        print(mid+1)
        break
