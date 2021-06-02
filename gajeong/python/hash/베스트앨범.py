def solution(genres, plays):
    answer = []
    gen = set(genres)
    dict = {i: 0 for i in gen}
    # 가장 많이 재생된 장르 순으로 dict 생성 및 정렬
    for i in range(len(genres)):
        v = dict.get(genres[i])
        v += plays[i]
        dict[genres[i]] = v
    dict = sorted(dict.items(), reverse=True, key=lambda item: item[1])

    genres_plays = [[i]for i in dict]

    # 장르별 인덱스값:재생횟수로 묶기
    for i, g in enumerate(genres):
        for j in range(len(genres_plays)):
            if g == genres_plays[j][0][0]:
                genres_plays[j].append([i, plays[i]])

    # 장르별 횟수별 내림차순 정렬
    for i in genres_plays:
        i.sort(key=lambda x: x[1], reverse=True)

    # genres_plays는 3중 배열로, [장르별[[인덱스, count]]]
    for i in genres_plays:
        if len(i) < 3:
            answer.append(i[1][0])
        else:
            for j in range(1, 3):
                answer.append(i[j][0])
    print(genres_plays)
    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays))
