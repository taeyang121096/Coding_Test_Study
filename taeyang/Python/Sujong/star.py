import sys

n = int(sys.stdin.readline().rstrip())

# 이중 반복문
# n = 5
# i = 0 -> 4번 띄어 -> j 0~4 -> 4번  n-1-i -> 4
# i = 1 -> 3번 -> j 0~ 3 -> n-1-i -> 3
#
for i in range(0,n):
    for j in range(0,n-1-i):
        print(end=" ")
    for j in range(0,i+1):
        print("*",end="")
    print()
