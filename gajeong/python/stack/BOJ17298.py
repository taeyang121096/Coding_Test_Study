import sys
n = int(input())
num = sys.stdin.readline().rstrip().split(' ')
num = list(map(int, num))
answer = [-1]*n
stack = []
# 수열의 크기 만큼 비교 해야 하므로 반복을 한다.
for i in range(n):
    # 스택이 비었는지 & 다음 숫자의 크기가 큰지 비교 한다
    while stack and num[stack[-1]] < num[i]:
        answer[stack.pop()] = num[i]
    # 다음 숫자가 더 작을 경우 다음 인덱스로 움직이기위해 스택에 넣어준다
    stack.append(i)

for i in answer:
    print(i, end=' ')
