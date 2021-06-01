import sys



N = int(sys.stdin.readline())
ans = 1
'''
# 백준 10872 팩토리얼  루프
# N이 0일 수도 있으니까 걸러줍니다
if N:
    for i in range(2, N+1):
        ans *= i
print(ans)
'''

# 백준 10872 팩토리얼  재귀

def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n-1)

print(factorial(N))