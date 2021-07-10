'''자릿수의 합'''
import sys

def digit_sum(x):
    ans = []
    for i in x:
        sum = 0
        for j in i:
            sum += eval(j)
        ans.append(sum)
    return ans




n = int(sys.stdin.readline())
num = sys.stdin.readline().strip().split(' ')
ans = digit_sum(num)
max_value = max(ans)
print(num[ans.index(max_value)])
