import re
''' 그냥 배열로 풀어 버릴경우'''
def solution(expression):
    answer = 0
    priority = [['+','-','*'],
                ['+','*','-'],
                ['-','+','*'],
                ['-','*','+'],
                ['*','-','+'],
                ['*','+','-']
                ]
    expression = re.split('([-,*,+])', expression)

    for i in priority:
        ls = expression[:]
        for j in i:
            while j in ls:
                indx = ls.index(j)
                ls[indx-1] = str(eval(ls[indx-1]+ls[indx]+ls[indx+1]))
                del ls[indx:indx+2]
        if answer < abs(int(ls[0])):
            answer = abs(int(ls[0]))

    return answer

expression = "100-200*300-500+20"
print(solution(expression))