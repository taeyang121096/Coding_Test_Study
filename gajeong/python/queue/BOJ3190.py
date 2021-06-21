import sys
from collections import deque
n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
apple = []
#사과 위치 
for i in range(k):
  x,y = map(int,sys.stdin.readline().rstrip().split(' '))
  apple.append([x,y])
l = int(sys.stdin.readline())

direction=deque()
for i in range(l):
  t,d = sys.stdin.readline().rstrip().split(' ')
  direction.append([t,d])

#뱀의 몸의 정보 
tale  =[1,1]
head = [1,1]

x = y=1
time=0
# 우 하 왼 상  // D이면 idx+1 | L이면 idx-1
x_direction = [1,0,-1,0]
y_direction = [0,1,0,-1]
idx = 0 
while l!=-1:
  if len(direction) != 0:
    queue = direction.popleft()
  else:
    queue[0]=9999
  while time != int(queue[0]):
    '''조건처리 '''
    if x>n or y>n:
      print('여기1')
      break
    elif x<1 or y<1:
      print('여기2')
      break
    elif head in tale and time!=0:
      print('여기3')
      break
    #사과가 있다면,, 
    x+=x_direction[idx]
    y+=y_direction[idx]  
    if [x,y] in apple:
      apple.remove([x,y])
      tale=[head[0],head[1]]
      head = [x,y]
    time+=1     

  # 방향처리   
  if queue[1]=='L':
    idx -=1 
    if idx<0:
      idx = 3
  elif queue[1]=='D':
    idx+=1 
    if idx>3:
      idx = 0
  l-=1
print(time)
    
