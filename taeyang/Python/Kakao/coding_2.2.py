
def solution(expression):
    answer = 0
    priority = [['+','-','*'],
                ['+','*','-'],
                ['-','+','*'],
                ['-','*','+'],
                ['*','-','+'],
                ['*','+','-']
                ]
    for i in priority:
        if answer < abs(int(cal(i,0,expression))):
            answer = abs(int(cal(i,0,expression)))

    return answer



def cal(op, index, exp):
    if exp.isdigit():
        return str(exp)
    else:
        if op[index] == '*':
            sp = exp.split('*')
            temp = []
            for i in sp:
                temp.append(cal(op, index+1,i))
            return str(eval('*'.join(temp)))
        if op[index] == '+':
            sp = exp.split('+')
            temp = []
            for i in sp:
                temp.append(cal(op, index+1,i))
            return str(eval('+'.join(temp)))
        if op[index] == '-':
            sp = exp.split('-')
            temp = []
            for i in sp:
                temp.append(cal(op, index+1,i))
            return str(eval('-'.join(temp)))

expression = "100-200*300-500+20"
print(solution(expression))