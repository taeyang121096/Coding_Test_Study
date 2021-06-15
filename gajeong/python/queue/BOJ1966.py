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
    idx = m
    while queue:
      print(queue,count,idx)
      if idx==0 and queue[0]==max(queue):
        break
      if queue[0]==max(queue):
        queue.popleft()
        idx-=1
        count+=1
        if idx<0:
          idx=len(queue)-1
      else:
        n = queue.popleft()
        queue.append(n)
        idx -=1
        if idx<0:
          idx=len(queue)-1
    answer.append(count+1)

for ans in answer:
  print(ans)
