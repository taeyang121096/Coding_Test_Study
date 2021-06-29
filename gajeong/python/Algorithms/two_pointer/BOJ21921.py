import sys
N,X = map(int,sys.stdin.readline().rstrip().split(' '))
visit = list(map(int,input().split(' ')))

start = end = 0
count = 0
max_visit = 0
visitor = 0 
for i in range(N):
  '''end가 N 길이를 넘으면 종료 '''
  if end==N:
    break
  '''x 일 동안 비교하기 위한 조건'''
  if end-start < X:
    end +=1 
    max_visit+=visit[i]
  elif end-start==X:
    visitor = max_visit - visit[start] + visit[end]
    end +=1
    start +=1 
    if visitor > max_visit:
      max_visit=visitor
      count = 1
    elif visitor==max_visit:
      count+=1
if max_visit==0:
  print("SAD")
else:
  print(max_visit)
  print(count)