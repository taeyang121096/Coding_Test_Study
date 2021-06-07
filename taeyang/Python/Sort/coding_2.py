import sys
''' 합병 정렬'''

def merge(left, right):
    sort = []
    i, j = 0, 0
    left_size = len(left)
    right_size = len(right)
    while left_size > i and right_size > j:
        if left[i] > right[j]:
            sort.append(right[j])
            j += 1
        else:
            sort.append(left[i])
            i += 1
    if left_size > i:
        sort.extend(left[i:])
    elif right_size > j:
        sort.extend(right[j:])

    return sort

def merge_sort(unsort):
  size = len(unsort)
  if size > 1:
    mid = size // 2
    return merge(merge_sort(unsort[:mid]), merge_sort(unsort[mid:]))
  else:
    return unsort

unsort = []
n = int(sys.stdin.readline())

for _ in range(n):
    unsort.append(int(sys.stdin.readline()))

sort = merge_sort(unsort)
for x in sort:
    print(x)