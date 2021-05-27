import sys

N, K = map(int, sys.stdin.readline().split())
member = [i for i in range(1,N+1)]
order = []
count = -1
for _ in range(N):
    count += K
    if count >= len(member) :
        ''' 나머지로 해결 할 수 있다'''
        count %= len(member)
    order.append(str(member.pop(count)))
    count -= 1

print("<",", ".join(order),">",sep='')

'''11866번 백준 요세푸스 문제 '''