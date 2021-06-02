''' 프로그래머스 베스트 앨범'''

def solution(genres, plays):
    answer = []
    kategorie = dict()
    index = dict()

    for i in range(len(genres)):
        if genres[i] in kategorie:
            kategorie[genres[i]] += plays[i]
        else:
            kategorie[genres[i]] = plays[i]
        index[i] = [plays[i],genres[i]]
    ''' 카테고리 내림 차순으로 정렬 ( 가장 큰 카테고리 찾기 ) '''
    kategorie = dict(sorted(kategorie.items(), key = lambda x:x[1], reverse = True))
    ''' 각각의 노래의 조회수 내림 차순으로 정렬 '''
    index = dict(sorted(index.items(), key = lambda x:x[1], reverse = True))

   # 인덱스 값 answer에 넣어 주는 부분
    for i in kategorie:
        count = 0
        for j in index:
            if count == 2:
                break
            if index[j][1] == i:
                answer.append(j)
                count += 1
    print(answer)
    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

solution(genres, plays)