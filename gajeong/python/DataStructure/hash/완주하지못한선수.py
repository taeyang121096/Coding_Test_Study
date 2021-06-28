def solution(participant, completion):
    answer = ''
    part_list = [0]*26
    comp_list = [0]*26
    # 완주자, 참가자 맨 처음 알파벳기준으로 갯수 count
    for i in completion:
        comp_list[ord(i[0])-97] += 1
    for i in participant:
        part_list[ord(i[0])-97] += 1
    diff = 0
    # 갯수 다른 알파벳 확인
    for i in range(len(part_list)):
        if part_list[i] != comp_list[i]:
            diff = i
            break
    comp_name = []
    part_name = []
    # 첫번째 알파벳갯수 차이나는 알파벳만 list에 추가
    for k in completion:
        if k[0] == chr(97+diff):
            comp_name.append(k)
    for k in participant:
        if k[0] == chr(97+diff):
            part_name.append(k)
    # 오름차순으로 정렬
    comp_name.sort()
    part_name.sort()

    # 값이 다른 참가자 확인
    for i in range(len(comp_name)):
        if comp_name[i] != part_name[i]:
            answer = part_name[i]
            break
    if answer == '':
        answer = part_name[-1]

    return answer
