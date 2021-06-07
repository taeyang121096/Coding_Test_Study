import sys
''' 선택 정렬 '''
N = int(sys.stdin.readline())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))



for i in range(N):
    minval = min(num[i:])
    temp = num[i]
    num[num.index(minval)] = temp
    num[i] = minval

for i in num:
    print(i)
