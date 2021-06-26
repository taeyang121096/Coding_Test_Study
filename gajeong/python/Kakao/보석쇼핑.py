'''
시간초과로 실패한 보석쇼핑 
완전탐색을 활용한 특정 문자열 길이만큼 비교하는 방식
데이터의 갯수가 최대 10000 이므로 시간적인 문제에서  
너무 오래걸려 정상적인 해답 X 

'''

def solution(gems):
    data = set(gems)
    # 보석의 갯수부터, 전체 보석까지  
    if len(data)==1:
      return [1,1]
    elif len(data)==len(gems):
      return [1,len(gems)]
    for i in range(len(data),len(gems)+1):
      #0번째 인덱스부터 ~ 마지막인데스- 봐야하는보석의 갯수 
      for j in range(0,len(gems)-i+1):
        if set(gems[j:j+i]) == data:
          return [j+1,j+i]


gems = 	["XYZ", "XYZ", "XYZ"]
print(solution(gems))