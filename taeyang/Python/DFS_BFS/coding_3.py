'''프로그래머스 타겟 넘버'''


def solution(numbers, target):
    answer = 0

    def dfs(index, sum):

        ''' target이랑 값이 같으면 answer를 1 더해준다'''
        if index == len(numbers):
            if target == sum:
                ''' nonlocal 하면 그 전 함수의 인자를 가져오는 거입니다.'''
                nonlocal answer
                answer += 1
                return
            else:
                return

        ''' 처음에는 더해주고 '''
        dfs(index + 1, sum + numbers[index])
        ''' 두번째에는 빼주고'''
        dfs(index + 1, sum - numbers[index])

    dfs(0,0)

    return answer


numbers = [1,1,1,1,1]
target = 3
print(solution(numbers,target))