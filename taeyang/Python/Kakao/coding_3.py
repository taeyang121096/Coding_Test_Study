''' 카카오 보석 쇼핑'''
def solution(gems):
    answer = []
    kategori = set(gems)
    start, end = 0,0
    jew = dict()
    min = len(gems) + 1

    while end < len(gems):

        if gems[end] not in jew:
            jew[gems[end]] = 1
        else:
            jew[gems[end]] += 1
        end += 1

        if len(jew) == len(kategori):
            while start < end:
                if jew[gems[start]] > 1:
                    jew[gems[start]] -= 1
                    start += 1
                elif min > end - start:
                    min = end - start
                    answer = [start +1, end]
                    break
                else:
                    break
        if min == len(kategori):
            break


    return answer

gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]

print(solution(gems))