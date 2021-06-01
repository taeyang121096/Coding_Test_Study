import sys
''' 1 ~ n 까지 합 루프'''

n = int(sys.stdin.readline())
'''
sum = 0

for i in range(1, n+1):
    sum += i

print(sum)
'''

''' 1 ~ n 까지 합 재귀'''
def recursion(n):
    if n == 1:
        return 1
    return n + recursion(n-1)

print(recursion(n))

