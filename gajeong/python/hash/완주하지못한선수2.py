def solution(participant, completion):
    answer = ''
    part_data = {}
    comp_data = {}
    for i in range(26):
        part_data.setdefault(chr(97+i), 0)
    for i in range(26):
        comp_data.setdefault(chr(97+i), 0)

    for i in completion:
        comp_data[i[0]] += 1
    print(comp_data)
    return answer


print(solution(["mislav", "stanko", "mislav", "ana"],
               ["stanko", "ana", "mislav"]))
