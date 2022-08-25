//def solution(n, lost, reserve):
//        answer = 0
//        rv = reserve.copy()
//        lt = lost.copy()
//        # 7 234 1236
//        for i in rv:
//        if i in lt:
//        reserve.remove(i)
//        lost.remove(i)
//        # 7, 4, 16
//        for i in range(n): # 0 1 2 3 4 5 6
//        if i+1 in lost: #
//        if i in reserve:
//        answer+=1
//        reserve.remove(i)
//        elif i+2 in reserve:
//        answer+=1
//        reserve.remove(i+2)
//        else:
//        answer+=1
//
//        return answer