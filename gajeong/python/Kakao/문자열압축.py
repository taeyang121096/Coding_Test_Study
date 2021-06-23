def solution(s):
  answer = 0
  l = 1
  data = []
  while True:
    #종료조건
    if l > len(s)//2:
      break
    answer = len(s)
    count = 0 

    #비교 데이터
    comp = s[0:l]

    # 문자길이  l만큼 잘라가면서 반복 
    for i in range(l,len(s),l):
      if s[i:i+l] == comp:
        count +=1
        continue      
      if count >= 1:
        answer -=(l-1)
        answer -= l*(count-1)
      count = 0        
      comp = s[i:i+l]
    if count >= 1:
      answer -=(l-1)
      answer -= l*(count-1)
    data.append(answer)   
    l+=1  
  return min(data)  

s = "abcabcdede"
print(solution(s))