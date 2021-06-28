# 선택정렬
import sys
lst = [9, 1, 6, 8, 4, 3, 2, 0]
# for i in range(len(lst)-1):
#     idx = i
#     for j in range(i+1, len(lst)):
#         if lst[j] < lst[i]:
#             idx = j
#         lst[i], lst[idx] = lst[idx], lst[i]

# 합병정렬
n = int(sys.stdin.readline())
arr = []
for i in range(n):
    num = int(sys.stdin.readline())
    arr.append(num)


def merge_sort(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr)//2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    merged_arr = []
    l = r = 0
    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            merged_arr.append(left[l])
            l += 1
        else:
            merged_arr.append(right[r])
            r += 1
    merged_arr += left[l:]
    merged_arr += right[r:]
    return merged_arr


lst = merge_sort(arr)

for i in lst:
    print(i)
