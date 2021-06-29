import sys
N, K= map(int,sys.stdin.readline().rstrip().split(' '))
array = list(map(int,input().split(' ')))

start = end = 0
nums = {}
max_length = 0 
for i in range(N):
  if N-start < max_length:
    break
  if start == end:
    continue 
  if array[end] in nums:
    # end 인덱스의 값이 k일 경우,
    if nums[array[end]] == K: 
      while nums[array[end]] < K:
        nums[array[start]] -=1
        start +=1 
  #end 인덱스의 값이 k보다 작을 경우 
  nums[array[end]]+=1
  

