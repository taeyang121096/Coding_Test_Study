''' 뒤집은 소수'''
import sys

def isPrime(num):
    flag = True
    if num == 1:
        return
    else:
        '''소수는 자신의 반 아래만 체크 해주면 된다!! ex) 16 일경우 -> 2 * 8 이므로 8까지만 체크 해주면 된다.'''
        for i in range(2,num//2+1):
            if num % i == 0:
                flag = False
                break
        if flag:
            print(num,end=' ')

def reverse(num):
    lt, rt = 0, len(num)-1
    while lt < rt:
        num[lt],num[rt] = num[rt],num[lt]
        lt += 1
        rt -= 1
    temp = ''.join(num)
    return int(temp)


N = int(sys.stdin.readline())
num = list(sys.stdin.readline().rstrip().split(' '))
for i in range(N):
    numb = list(num[i])
    number = reverse(numb)
    isPrime(number)