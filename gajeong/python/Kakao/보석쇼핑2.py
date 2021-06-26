'''
투 포인터 알고리즘 
시작접과 끝점을 이용해 동시에 증가하면서 순차적으로 탐색하는 것으로,
투 포인터 알고리즘을 적용하면, 찾고자하는 구간의 조건을 만족할때까지
끝점을 먼저 증가시키고, 그 뒤에 
해당 구간을 최소화하도록 시작점을 증가시켜 최소구간을 찾게됨. 
'''

def solution(gems):
    answer = []
    start = end = 0
    data = set(gems)
    shop = {}
    shortest_length = len(data)+1
    while end<len(gems):
      if gems[end] not in shop:
        shop[gems[end]]=1
      else:
        shop[gems[end]] +=1
      end+=1
      if len(shop) == len(data): 
        while start<end:
          if shop[gems[start]]>1:
            shop[gems[start]]-=1
            start+=1
            answer = [start+1, end]
          elif shortest_length > end - start:
            shortest_length = end - start
            answer = [start+1, end]
          else:
            break
    return answer


gems =["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
print(solution(gems))