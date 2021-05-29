import sys
'''숫자들이 차례대로 정렬 되어 있으므로
   길이의 절반을 기준으로 앞과 뒤로 나누어서 생각하면 된다
   1021 백준 회전하는 큐
'''
N, M = map(int, sys.stdin.readline().rstrip().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))

count = 0
queue = [i for i in range(1, N+1)]

for i in num:
    while True:
        if i == queue[0]:
            queue.pop(0)
            break
        else:
            if len(queue) % 2 == 0:
                if queue.index(i) < len(queue) / 2 :
                    count += 1
                    queue.append(queue.pop(0))
                else:
                    count += 1
                    queue.insert(0, queue.pop())
            else:
                if queue.index(i) < len(queue) / 2:
                    count += 1
                    queue.append(queue.pop(0))
                else :
                    count += 1
                    queue.insert(0, queue.pop())

print(count)








