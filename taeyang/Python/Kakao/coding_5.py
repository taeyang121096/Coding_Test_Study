'''프로그래머스 카카오 괄호변환'''

def solution(p):
    if not p:
        return p

    count = 0
    for i in range(len(p)):
        if p[i] =='(':
            count += 1
        else:
            count -= 1
        if count == 0:
            u = p[:i+1]
            v = p[i+1:]
            break
    if check(u):
        return u + solution(v)
    else:
        return '('+solution(v)+')' + reverse(u[1:-1])


def check(u):
    count = 0
    if u[0] == '(':
        return True
    return False

def reverse(u):
    word = ''
    for i in u:
        if i == '(':
            word += ')'
        else:
            word += '('
    return word


print(solution("()))((()"	))