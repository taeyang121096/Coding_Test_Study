import sys
'''백준 9012 문제'''
T = int(sys.stdin.readline())
for _ in range(T):
    ls = sys.stdin.readline().rstrip()
    stack = []
    '''flag 스택이 비었는지 안비었는지 확인 및 짝이 맞는지 체크 해준다'''
    flag = False
    for i in ls:
        if i == '(':
            stack.append(i)
        else:
            if len(stack):
                stack.pop()
            else:
                flag = True
                break
    if len(stack):
        flag = True

    if flag:
        print('NO')
    else:
        print('YES')


