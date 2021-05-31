import sys
'''백준 1874 문제'''
n = int(sys.stdin.readline())
stack = []
ans = []

num = [int(sys.stdin.readline()) for _ in range(n)]
count = 1

''' stack 사용해서 count를 통해서 오름 차순으로 쌓고
    stack 마지막 이랑 수열 비교해서 pop하게 끔 잤다.
    +, - 는 ans에 차곡차곡 넣었습니다.
    '''
for i in num:
    while count <= n+1:
        if not len(stack):
            stack.append(count)
            count += 1
            ans.append('+')
            continue
        if stack[-1] == i:
            stack.pop()
            ans.append('-')
            break
        stack.append(count)
        count += 1
        ans.append('+')

        ''' 여긴 출력 부분'''
if len(stack):
    print('NO')
else:
    for i in ans:
        print(i)
