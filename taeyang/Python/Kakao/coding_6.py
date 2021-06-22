''' 프로그래머'''

def solution(s):
    size = len(s)
    answer = size

    for i in range(1, (size//2) + 1):
        stack = []
        temp = s
        word = ''

        while temp:
            if not stack:
                stack.append(temp[:i])
                temp = temp[i:]
            if stack[-1] != temp[:i]:
                num = len(stack)
                if num > 1:
                    word += str(num) + stack[-1]
                else:
                    word += stack[-1]
                stack.clear()
            stack.append(temp[:i])
            temp = temp[i:]

        if stack:
            if len(stack) > 1:
                word += str(len(stack)) + stack[-1]
            else:
                word += stack[-1]

        word += temp

        if answer > len(word):
            answer = len(word)

    return answer


s = "abcabcabcabcdededededede"
print(solution(s))