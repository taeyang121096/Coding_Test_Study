n = int(input())
count = 0
for i in range(1, 9):
    if n < 10:
        count += (1*n)
    if n < 100:
        count += 2 * ()
    elif n < 1000:
        count += (3*(n - n % 100))
print(count)
