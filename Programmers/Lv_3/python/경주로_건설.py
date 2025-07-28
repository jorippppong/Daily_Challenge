# https://school.programmers.co.kr/learn/courses/30/lessons/67259

import math, collections

def canGo(x, y, length, board):
    return -1 < x < length and -1 < y < length and board[x][y] != 1

def bfs(board):
    length = len(board)
    table = [[[math.inf]*4 for _ in range(length)] for _ in range(length)]
    table[0][0] = [0, 0, 0, 0]
    dq = collections.deque()
    dq.append((0, 0, 4)) # (현재x, 현재y, 방향)
    
    # 오, 아래, 위, 왼 
    dx = [0, 1, -1, 0]  
    dy = [1, 0, 0, -1]
    cost = 0
    while dq:
        currX, currY, currDir = dq.popleft()
        for i in range(4):
            if i + currDir == 3:
                continue
                
            if canGo(currX+dx[i], currY+dy[i], length, board):
                if currDir == 4:
                    cost = 100
                # 같은 방향
                elif currDir == i:
                    cost = table[currX][currY][currDir] + 100
                else:
                    cost = table[currX][currY][currDir] + 600
                
                if cost < table[currX + dx[i]][currY + dy[i]][i]:
                    table[currX + dx[i]][currY + dy[i]][i] = cost
                    # 다음 위치 추가
                    dq.append((currX + dx[i], currY + dy[i], i))
    return min(table[-1][-1])

def solution(board):
    return bfs(board)