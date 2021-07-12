'''카드 역배치'''
import sys

card = [i for i in range(1,21)]


for _ in range(10):
    start, end = map(int, sys.stdin.readline().rstrip().split(' '))
    start -= 1
    end -= 1
    while start < end :
        card[start], card[end] = card[end], card[start]
        start += 1
        end -= 1
card = list(map(str,card))
print(' '.join(card))