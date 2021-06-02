'''백준 수 이어쓰'''
import sys
'''

num = sys.stdin.readline().rstrip()
ans = 0
if len(num) == 1:
    ans = int(num)
elif len(num) == 2:
    val = int(num)
    ans = (val - 10 + 1) * 2 + 9

elif len(num) == 3:
    val = int(num)
    ans = (val - 100 + 1) * 3 + (99 - 10 + 1) * 2 + 9

elif len(num) == 4:
    val = int(num)
    ans = (val - 1000 + 1) * 4 + (999 - 100 + 1) * 3 + (99 - 10 + 1) * 2 + 9

elif len(num) == 5:
    val = int(num)
    ans = (val - 10000 + 1) * 5 + (9999 - 1000 + 1) * 4 + (999 - 100 + 1) * 3 + (99 - 10 + 1) * 2 + 9

elif len(num) == 6:
    val = int(num)
    ans = (val - 100000 + 1) * 6 + (99999 - 10000 + 1) * 5+(9999 - 1000 + 1) * 4 + (999 - 100 + 1) * 3 + (
                99 - 10 + 1) * 2 + 9

elif len(num) == 7:
    val = int(num)
    ans = (val - 1000000 + 1) * 7 + (999999 - 100000 + 1) * 6 + (99999 - 10000 + 1) * 5+(9999 - 1000 + 1) * 4 + (
                999 - 100 + 1) * 3 + (99 - 10 + 1) * 2 + 9

elif len(num) == 8:
    val = int(num)
    ans = (val - 10000000 + 1) * 8 + (9999999 - 1000000 + 1) * 7 + (999999 - 100000 + 1) * 6 + (99999 - 10000 + 1) * 5+(
        9999 - 1000 + 1) * 4 + (999 - 100 + 1) * 3 + (99 - 10 + 1) * 2 + 9

elif len(num) == 9:
    val = int(num)
    ans = (val - 100000000 + 1) * 9 + (99999999 - 10000000 + 1) * 8 + (9999999 - 1000000 + 1) * 7 + (
                999999 - 100000 + 1) * 6 + (99999 - 10000 + 1) * 5+(9999 - 1000 + 1) * 4 + (999 - 100 + 1) * 3 + (
                      99 - 10 + 1) * 2 + 9

print(ans)

'''
n = int(sys.stdin.readline())
cnt = 0
i = 1
k = 1
while i <= n:
  j = i * 10 - 1
  if j > n: j = n
  cnt += (j - i + 1) * k
  i *= 10
  k += 1
print(cnt)
