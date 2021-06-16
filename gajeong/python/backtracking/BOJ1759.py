import sys

L, C = map(int, input().split(' '))
data = sys.stdin.readline().rstrip().split(' ')
mo = []
ja = []

n = L- 2 # n = 4-2
for i in data:
    if i in 'aeiou':
        mo.append(i)
    else:
        ja.append(i)

data.sort()
