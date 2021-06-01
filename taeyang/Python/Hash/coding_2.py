'''' 일단 숫자들을 차례대로 나열 했다
     정렬을 시키면 앞의 숫자들 순서로 나열 되므로 접두사 찾기 편해진다
     처음에는 in을 사용했지만 생각해보니 가운데 숫자도 걸리기 되므로
     str.startswith()를 사용했다.
     프로그래머스 전화 번호 목록
'''

def solution(phone_book):
    answer = True
    phone_book.sort()

    for i in range(len(phone_book) - 1 ):
        if phone_book[i+1].startswith(phone_book[i]):
            answer = False
            break

    return answer


print(solution(phone_book = ['119','97674223','1195524421']))