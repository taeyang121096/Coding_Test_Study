'''프로그래머스 광고 삽입'''


def maketime(ls):
    time = 0
    for i in range(3):
        if i == 0:
            time += ls[i] * 60 * 60
        elif i == 1:
            time += ls[i] * 60
        else:
            time += ls[i]
    return time


def solution(play_time, adv_time, logs):
    answer = ''
    play = maketime(list(map(int, play_time.split(':'))))
    adv = maketime(list(map(int, adv_time.split(':'))))

    play_matrix = [0 for _ in range(play + 1)]

    for i in logs:
        tmp = i.split('-')
        for j in range(2):
            if j == 0:
                start = maketime(list(map(int, tmp[j].split(':'))))
            else:
                end = maketime(list(map(int, tmp[j].split(':'))))
        play_matrix[start] += 1
        play_matrix[end] -= 1

    for i in range(1, play + 1):
        play_matrix[i] += play_matrix[i - 1]

    timesum = sum(play_matrix[:adv])
    maxsum = timesum
    index = 0

    for i in range(adv, play + 1):
        timesum = timesum + play_matrix[i] - play_matrix[i - adv]
        if timesum > maxsum:
            maxsum = timesum
            index = i - adv + 1
    hour = index // 3600
    minute = (index % 3600) // 60
    sec = (index % 3600) % 60

    answer = '%02d:%02d:%02d' % (hour, minute, sec)

    return answer

