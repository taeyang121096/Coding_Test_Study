''' 네트워크 선 자르기 dp'''

import sys

n = int(sys.stdin.readline())

count = [1,2]

for i in range(2,n):
    tmp = count[i-2] + count[i-1]
    count.append(tmp)
print(count[-1])