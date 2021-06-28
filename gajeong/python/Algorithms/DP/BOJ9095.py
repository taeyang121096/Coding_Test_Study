import sys
t = int(sys.stdin.readline())
dp = [0,1,2,4]
answer = []
for j in range(4,12):
  dp.append(dp[j-1]+dp[j-2]+dp[j-3])

for i in range(t):
  n = int(sys.stdin.readline())
  answer.append(n)

for i in answer:
  print(dp[i])