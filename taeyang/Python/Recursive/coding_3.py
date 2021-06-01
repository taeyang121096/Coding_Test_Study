import sys
N = int(sys.stdin.readline())
'''
num = [0, 1]

# 백준 10870 피보나치  루프
for i in range(N-1):
    num.append(num[i]+num[i+1])
print(num[N])
'''
# 백준 10870 피보나치  재귀

def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    return fibo(n-1) + fibo(n-2)

print(fibo(N))



