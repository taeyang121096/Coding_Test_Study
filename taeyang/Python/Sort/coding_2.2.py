import sys
''' 합병 정렬'''

N = int(sys.stdin.readline())
num = []


for i in range(N):
    num.append(int(sys.stdin.readline()))


def merge_sort(num):
    n = len(num)
    if n <= 1:
        return num
    else:
        mid = n // 2
        left = merge_sort(num[0:mid])
        right = merge_sort(num[mid:n])
        return merge(left, right)

def merge(left, right):
    res = []
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            res.append(left[i])
            i += 1
        else:
            res.append(right[j])
            j += 1
    if i == len(left):
        res += right[j:len(right)]
    if j == len(right):
        res += left[i:len(left)]
    return res

ls = merge_sort(num)
for i in ls:
    print(i)







