from collections import deque
import sys

test = int(sys.stdin.readline())
answer = []
for i in range(test):
    n, m = map(int, sys.stdin.readline().rstrip().split(' '))
    queue = deque(map(int, sys.stdin.readline().rstrip().split(' ')))
    
    if n ==1:
      answer.append(1)
      continue

    count = 0
    while queue:
      if m==0 and queue[0]==max(queue):
        break
      if queue[0]==max(queue):
        queue.popleft()
        m-=1
        count+=1
        if m<0:
          m=len(queue)-1
      else:
        n = queue.popleft()
        queue.append(n)
        m -=1
        if m<0:
          m=len(queue)-1
    answer.append(count+1)

for ans in answer:
  print(ans)
