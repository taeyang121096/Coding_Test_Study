''' 카카오 경주로 건설 '''
from collections import deque

def solution(board):
    answer = 0
    ''' 앞 뒤 위 아래'''
    xdirection = [1,-1,0,0]
    ydirection = [0,0,-1,1]
    queue = deque([])
    queue.append([0,0,0,0])
    costBoard = [[0 for _ in range(len(board))] for _ in range(len(board))]

    while queue:
        x, y, cost, direction = queue.popleft()
        for dir in range(4):
            X = x + xdirection[dir]
            Y = y + ydirection[dir]

            if 0 <= X <len(board) and 0 <= Y < len(board) :
                if not board[X][Y]:
                    if X == 0 and Y ==0:
                        continue
                    if x == 0 and y == 0:
                        Cost = cost + 100
                    else:
                        if dir == direction:
                            Cost = cost + 100
                        else:
                            Cost = cost + 500 + 100
                    if costBoard[X][Y] == 0:
                        costBoard[X][Y] = Cost
                        queue.append([X,Y,Cost,dir])
                    else:
                        if costBoard[X][Y] >= Cost:
                            costBoard[X][Y] = Cost
                            queue.append([X,Y,Cost,dir])
    answer = costBoard[-1][-1]

    return answer


board = [[0,0,0],
         [0,0,0],
         [0,0,0]]

print(solution(board))