import sys

N = int(sys.stdin.readline())
queue = []
''' 
pop()을 사용했더니 시간 초과가 떴다 pop을 사용할 경우 리스트들이 앞으로 땡겨져야 되서 시간 초과가 뜬거 같다.
인덱스의 첫 원소를 나타내는 cnt 변수를 사용하여 pop을 하지 않고 풀이 했다.
'''
cnt = 0
for _ in range(N):
    command, _,  n = sys.stdin.readline().rstrip().partition(' ')
    if command == 'push':
        queue.append(n)
    elif command == 'pop':
        if len(queue) <= cnt:
            print(-1)
        else:
            print(queue[cnt])
            cnt += 1
    elif command == 'size':
        print(len(queue) - cnt)
    elif command == 'empty':
        if len(queue) == cnt:
            print(1)
            cnt = 0
            queue = []
        else:
            print(0)
    elif command == 'front':
        if len(queue) == cnt:
            print(-1)
        else:
            print(queue[cnt])
    else:
        if len(queue) == cnt:
            print(-1)
        else:
            print(queue[-1])

'''백준 18258 큐2 문제'''








