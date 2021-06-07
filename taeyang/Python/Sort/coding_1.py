import sys

'''내장 함수 sort 사용한 경우'''

N = int(sys.stdin.readline())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))

num.sort()

for result in num:
    print(result)