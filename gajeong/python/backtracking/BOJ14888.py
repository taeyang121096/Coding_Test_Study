# 순열 활용한 반복문 ,,,,
import sys
from itertools import permutations
n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
op = list(map(int, sys.stdin.readline().rstrip().split(' ')))
answer = []
operate = []
# op 리스트  + = 0 , - = 1, * = 2 , / =3 순으로
for i, data in enumerate(op):
    if data != 0:
        for j in range(data):
            operate.append(i)


# 연산자 우선순위 순열


for i in set(permutations(operate, n-1)):
    result = numbers[0]
    idx = 1

    for oper in i:
        if oper == 0:
            result += numbers[idx]
        elif oper == 1:
            result -= numbers[idx]
        elif oper == 2:
            result *= numbers[idx]
        elif oper == 3:
            if result < 0:
                result = -result
                result //= numbers[idx]
                result = -result
            else:
                result //= numbers[idx]
        idx += 1
    answer.append(result)
print(max(answer))
print(min(answer))
