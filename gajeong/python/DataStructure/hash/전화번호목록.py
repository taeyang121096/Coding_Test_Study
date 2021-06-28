def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return answer


print(solution(["12", "123", "1235", "567", "88"]))


string_list = ['A', 'B', 'C']
dict = {string: 0 for string in string_list}
dict = {string: i for i, string in enumerate(string_list)}
