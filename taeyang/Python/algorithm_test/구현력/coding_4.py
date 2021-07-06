''' 대표값'''
import sys

n = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split(' ')))
avg = round(sum(score) / len(score))
dif = sys.maxsize
min = []
for i in score:
    if abs(avg - i) <= dif:
        dif = abs(avg - i)
        min.append(i)
if len(min) > 1:
    min = min[1:]
max_num = max(min)

print(avg, score.index(max_num)+1)

