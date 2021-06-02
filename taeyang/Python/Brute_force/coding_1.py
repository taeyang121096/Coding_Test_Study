''' 백준 1107번 리모컨'''

import sys

first = 100


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

fail = sys.stdin.readline().rstrip().split()
number = [i for i in range(10)]

for i in fail:
    number.remove(int(i))

def checkNumber(n):
    strs = str(n)
    count = 0
    for i in strs:
        if int(i) not in number:
            return False
        count += 1
    return count

count = abs(100 - n)
for num in range(1000001):
    ret = checkNumber(num)
    if ret:
        if count > ret + abs(n - num):
            count = ret + abs(n - num)
print(count)



