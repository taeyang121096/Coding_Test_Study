import sys

word = list(sys.stdin.readline().rstrip().split(" "))
cnt = 0
for i in range(0, len(word)):
    if word[i] == '':
        continue
    cnt += 1
print(cnt)