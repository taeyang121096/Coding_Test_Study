def solution(numbers):
    answer = ''
    if max(numbers) == '0':
        answer = '0'
    data = numbers.copy()
    data = list(map(str, data))
    data.sort(key=lambda x: x*3, reverse=True)
    ''.join(data)
    return answer


numbers1 = [6, 10, 2]
numbers2 = [3, 30, 34, 5, 9]

solution(numbers1)
