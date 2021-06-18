'''프로그래머스 단어변환 '''


def solution(begin, target, words):
    answer = 0
    stack = [begin]
    index = 0
    if target not in words:
        return 0

    while stack:
        count = 0
        root = stack.pop()

        if root == target:
            break

        for i in range(index,len(words)):
            for j in range(len(root)):
                if words[i][j] != root[j]:
                    count += 1
                    temp = j
                if count > 1:
                    count = 0
                    break
            if count == 1:
                count = 0
                for k in range(len(root)):
                    if root[k] != target[k]:
                        count += 1
                if count == 1 and words[i] != target:
                    stack.append(root)
                    index = i+1
                    break

                answer += 1
                root = root[:temp]+words[i][temp]+root[temp+1:]
                print(root)
                stack.append(root)
                index = i + 1
                break



    return answer


begin = 'hit'
target = 'cog'
words = ["hot", "dot", "dog", "lot", "log", "cog"]

print(solution(begin, target, words))