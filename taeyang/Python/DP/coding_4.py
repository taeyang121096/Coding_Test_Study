''' 프로그래머스 정수 삼각형'''

def solution(triangle):
    answer = 0
    for i in range(1,len(triangle)):
        for j in range(i+1):
            ''' 삼각형의 특성상 양 끝 정점만 생각 해주면 되고 나머지는 큰값으로 치환 해주면 된다.'''
            if j == 0:
                triangle[i][j] += triangle[i-1][0]
            elif j == i:
                triangle[i][j] += triangle[i-1][j-1]
            else:
                triangle[i][j] += max(triangle[i-1][j],triangle[i-1][j-1])

    print(triangle)


    answer = max(triangle[-1])

    return answer



triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
print(solution(triangle))