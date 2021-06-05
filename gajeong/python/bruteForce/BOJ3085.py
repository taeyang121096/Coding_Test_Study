n = int(input())
data = []
for i in range(n):
    data.append(list(input()))
row = []
col = []
for i in range(n):
    for j in range(n):
        if i == n-1 or j == n-1:
            break
        if data[i][j] != data[i+1][j]:
            tmp = data[i][j]
            data[i][j] = data[i+1][j]
