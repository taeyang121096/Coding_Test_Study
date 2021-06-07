import sys

''' 버블 정렬'''
N = int(sys.stdin.readline())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))

for i in range(N-1):
    for j in range(N-i-1):
        if num[j+1] < num[j]:
            num[j], num[j+1] = num[j+1], num[j]

for i in num:
    print(i)

