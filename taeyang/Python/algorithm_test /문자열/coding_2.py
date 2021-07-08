'''숫자만 추출'''

import sys

data = sys.stdin.readline().strip()
num =''
for i in data:
    if i.isdigit():
      num += i
num = int(num)
count = 0
for i in range(1,num+1):
    if num % i == 0:
        count += 1
print(num)
print(count)