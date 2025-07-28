# https://school.programmers.co.kr/learn/courses/30/lessons/1844

import math
from collections import deque

#### BFS (정답)
def solution(maps):
    row, col = len(maps), len(maps[0])
    answer = math.inf
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]  # 동남서북
    dp = [[math.inf]*col for _ in range(row)]
    dp[0][0] = 1
    dq = deque()
    dq.append((0, 0, 1))
    
    def canGo(x, y):
        return 0<=x<row and 0<=y<col and maps[x][y]
    
    while dq:
        currX, currY, blocks = dq.popleft()
        if currX==row-1 and currY ==col-1:
            dp[currX][currY] = min(dp[currX][currY], blocks)
        for i in range(4):
            nextX, nextY = currX + dx[i], currY + dy[i]
            if canGo(nextX, nextY) and dp[currX][currY]+1 < dp[nextX][nextY]:
                dp[nextX][nextY] = dp[currX][currY]+1
                dq.append((nextX, nextY, blocks+1))
    
    return -1 if dp[row-1][col-1] == math.inf else dp[row-1][col-1]


#### DFS (시간 초과)
def solution2(maps):
    row, col = len(maps), len(maps[0])
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]  # 동남서북
    dp = [[math.inf]*col for _ in range(row)]
    
    def canGo(x, y):
        return 0<=x<row and 0<=y<col and maps[x][y]
    
    def move(currX, currY, blocks):
        if currX==row-1 and currY ==col-1:
            dp[row-1][col-1] = min(dp[row-1][col-1], blocks+1)
            return
        for i in range(4):
            nextX, nextY = currX + dx[i], currY + dy[i]
            if canGo(nextX, nextY):
                if dp[currX][currY]+1 < dp[nextX][nextY]:
                    dp[nextX][nextY] = dp[currX][currY]+1
                    move(nextX, nextY, dp[nextX][nextY])
        return 
    
    dp[0][0] = 1
    move(0, 0, 1)
    return -1 if dp[row-1][col-1] == math.inf else dp[row-1][col-1]
