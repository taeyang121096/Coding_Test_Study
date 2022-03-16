import sys

# n,x -> 1 ~ 1만
# x 보다 작은 수만 출력한다.

n, x = map(int, sys.stdin.readline().rstrip().split(" "))

a = list(map(int,sys.stdin.readline().rstrip().split(" ")))

answer = list()

for i in a:
    if i < x:
        answer.append(str(i))

print(" ".join(answer))