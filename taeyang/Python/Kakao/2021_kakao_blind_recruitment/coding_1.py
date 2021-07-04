''' 프로그래머스 신규 아이디 찾기'''


def solution(new_id):
    answer = ''
    new_id = new_id.lower()
    for i in new_id:
        if i in ('-', '_', '.') or i.isalnum():
            answer += i
    while '..' in answer:
        answer = answer.replace('..', '.')
    answer = answer.strip('.')

    if not answer:
        answer += 'a'
    if len(answer) >= 16:
        answer = answer[:15]
        answer = answer.rstrip('.')
    while len(answer) < 3:
        answer += answer[-1]

    return answer