''' 랜선자르기'''
import sys

k, n = map(int, sys.stdin.readline().strip().split(' '))
lan = []
for _ in range(k):
    lan.append(int(sys.stdin.readline()))
lan.sort()
start, end = 1, lan[-1]

def Count(mid):
    count = 0
    for i in lan:
        count += i//mid
    return count



while start <= end:
    mid = (start+end)//2
    if Count(mid) >= n:
        res = mid
        start = mid + 1
    else:
        end = mid - 1


print(res)