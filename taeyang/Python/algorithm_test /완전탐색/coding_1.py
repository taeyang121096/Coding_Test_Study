'''재귀함수를 이용한 이진수 출력'''
import sys

def dfs(num):
    if num == 1:
        return print(num, end='')
    dfs(num//2)
    print(num%2,end='')

n = int(sys.stdin.readline())

dfs(n)