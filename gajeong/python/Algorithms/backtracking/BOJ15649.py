import sys

# 1부터 n까지의 자연 수 중
# 길이가 m 인 수열을 모두 구하는 프로그램
n, m = map(int, sys.stdin.readline().rstrip().split(' '))

visit = [False]*(n)
answer = []


def back(cnt):
    # 조건처리
    if cnt == m:
        print(" ".join(map(str, answer)))
        return

    # 갈곳처리
    for i in range(n):
        # 방문처리
        if not visit[i]:
            visit[i] = True
            answer.append(i+1)
            back(cnt+1)
            answer.pop()
            visit[i] = False


back(0)
