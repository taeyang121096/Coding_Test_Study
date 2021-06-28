def solution(numbers):
    answer = ''
    if max(numbers) == 0:
        return "0"
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    answer = ''.join(numbers)
    return answer


numbers1 = [6, 10, 2]
numbers2 = [3, 30, 34, 5, 9]

print(solution(numbers1))
