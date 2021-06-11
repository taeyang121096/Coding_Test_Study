'''백준 1759'''
import sys

L, C = map(int, sys.stdin.readline().rstrip().split())
char = sys.stdin.readline().rstrip().split()

ans = []
cipher =''
vcount = 0
vowel ='aeiou'

def dfs(n):
    global cipher, vcount

    if n == L:
        for i in cipher:
            if i in vowel:
                sort = ''.join(sorted(cipher))
                if cipher == sort:
                    ans.append(cipher)
                    return
        return

    for i in char:
        if i not in cipher:
            cipher += i
            n += 1
            dfs(n)
            cipher = cipher[:-1]
            n -= 1

dfs(0)
ans.sort()
print(ans)