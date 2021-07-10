'''소수(에라토스테네스 체)'''
import sys

n = int(sys.stdin.readline())
ans = [0] * (n+1)
count = 0

for i in range(2 ,n+1):
    if ans[i] == 0:
        count += 1
        for j in range(i,n+1,i):
            ans[j] += 1
print(count)
