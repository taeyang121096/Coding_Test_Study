'''백준 1759'''
import sys

L, C = map(int, sys.stdin.readline().rstrip().split())
char = sys.stdin.readline().rstrip().split()
char.sort()
ans = set()
cipher =''
vowel ='aeiou'

def dfs(index, n):
    global cipher

    if n == L:
        vcount, mcount = 0,0
        for i in cipher:
            if i in vowel:
                vcount += 1
            else:
                mcount += 1
        if vcount >= 1 and mcount >= 2:
            ans.add(''.join(sorted(cipher)))
        return

    for i in char[index:]:
        if i not in cipher:
            cipher += i
            n += 1
            index += 1
            dfs(index, n)
            cipher = cipher[:-1]
            n -= 1


dfs(0, 0)
ans = sorted(list(ans))
for i in ans:
    print(i)