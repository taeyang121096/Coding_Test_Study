n = int(input())


def fac(n):
    if n == 1:
        return 1
    return n*fac(n-1)


print(fac(n))
