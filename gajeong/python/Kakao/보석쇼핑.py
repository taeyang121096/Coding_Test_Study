def solution(gems):
    answer = []
    data = set(gems)

    print(data)

    for i in range(len(data),len(gems)):
      for j in range(0,len(gems)-i):
        print(j)
        print(set(gems[j:j+i]))
        if set(gems[j:j+i+1]) == data:
          return [j+1,j+i]
    return answer

gems = ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]
print(solution(gems))