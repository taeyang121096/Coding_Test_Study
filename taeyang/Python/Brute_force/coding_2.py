''' 백준 3085 사탕 게임'''
import sys
def checkSubString(arr):
    size = len(arr)
    cnt = 1
    for i in range(size):
        length = 1
        for j in range(size - 1):
            if arr[i][j] == arr[i][j + 1]:
                length += 1
            else:
                length = 1
            if cnt < length:
                cnt = length

        length = 1
        for j in range(size - 1):
            if arr[j][i] == arr[j + 1][i]:
                length += 1
            else:
                length = 1
            if cnt < length:
                cnt = length
    return cnt


n = int(sys.stdin.readline())
arr = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
cnt = 1

for i in range(n):
    for j in range(n):

        if i + 1 < n:
            # 인접한 행을 바꿔줍니다.
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

            # 리스트를 전부 순회하면서 같은 문자열의 최대 길이를 찾음
            tmp = checkSubString(arr)
            if cnt < tmp:
                cnt = tmp

            # 변경된 리스트는 다시 원복
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

        if j + 1 < n:
            # 인접합 열을 바꿔줍니다.
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

            tmp = checkSubString(arr)
            if cnt < tmp:
                cnt = tmp

            # 변경된 리스트는 다시 원복
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

print(cnt)
