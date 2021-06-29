'''프로그래머스 신규 아이디 추천'''

def solution(new_id):
    answer = ''
    new_id = new_id.lower()
    word = ''
    ''' 문자열 제거하기 '''
    for i in range(len(new_id)):
        if new_id[i]  in ('-','_','.') or  new_id[i].isalnum():
            word += new_id[i]
    ''' 문자열의 .. 이상인걸 .으로 치환 해주기'''
    while '..' in word:
        word = word.replace('..','.')
    ''' 문자열의 앞뒤의 .을 제거 해주고 빈 공간도 제거 해주기'''
    word = word.strip('.')
    word = word.strip('')

    ''' 나머지는 문자열의 길이에 맞게 변환 해주기'''
    if not word:
        word += 'a'
    if len(word) >= 16:
        word = word[:15]
        if word[-1] == '.':
            word = word[:14]
    while len(word) < 3:
        word += word[-1]


    answer = word
    return answer

new_id = "...!@BaT#*..y.abcdefghijklm"
print(solution(new_id))
