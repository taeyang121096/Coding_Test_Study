def solution(numbers):
    answer = ''
    if max(numbers) == 0:
        answer = '0'

    else:
        numbers = list(map(str, numbers))
        numbers.sort(key= lambda x: x*3, reverse = True)
        answer = ''.join(numbers)
    return answer


numbers = [0, 0, 0]
print(solution(numbers))



