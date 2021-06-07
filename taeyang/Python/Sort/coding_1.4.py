import sys

''' 삽입 정렬 '''
N = int(sys.stdin.readline())
num = []

for i in range(N):
    num.append(int(sys.stdin.readline()))

for i in range(1, N):
    if num[i] > num[i-1]:
        continue
    else:
        for j in reversed(range(i)):
            if num[j] > num[j+1]:
                num[j], num[j+1] = num[j+1], num[j]
            else:
                break
for i in num:
    print(i)



