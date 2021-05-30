import sys
''' 덱을 사용하지는 않았는데...'''
T = int(sys.stdin.readline())
for _ in range(T):
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    ls = sys.stdin.readline().rstrip()[1:-1].split(',')
    flag = False
    front, end = -1, len(ls)
    for command in p:
        if command == 'R':
            temp = end
            end = front
            front = temp
        elif command == 'D':
            if abs(front - end) == 1:
                flag = True
                break
            if len(ls) == 1:
                if ls[0] =='':
                    flag = True
                    break
            if front < end:
                front += 1
            else:
                front -= 1
        else:
            flag = True
    if flag:
        print('error')
    else:
        if front < end:
            print('[',end='')
            print(','.join(ls[front + 1:end:]),end='')
            print(']')
        elif front > end:
            if end < 0:
                print('[', end='')
                print(','.join(ls[front - 1::-1]), end='')
                print(']')
            else:
                print('[', end='')
                print(','.join(ls[front - 1:end:-1]), end='')
                print(']')