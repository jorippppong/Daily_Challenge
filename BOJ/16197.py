# https://www.acmicpc.net/problem/16197

from collections import deque

row, col = map(int, input().split())
board = [input() for _ in range(row)]
coins = []
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

for i in range(row):
    for j in range(col):
        if board[i][j] == 'o':
            coins.append([i, j])

def bfs():
    dq = deque()
    dq.append((coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0))
    while dq:
        x1, y1, x2, y2, cnt = dq.popleft()
        if cnt >= 10:
            return -1 
        for i in range(4):
            nx1 = x1 + dx[i]
            ny1 = y1 + dy[i]
            nx2 = x2 + dx[i]
            ny2 = y2 + dy[i]
            if inRange(nx1, ny1) and inRange(nx2, ny2):
                if board[nx1][ny1] == "#":
                    nx1, ny1 = x1, y1
                if board[nx2][ny2] == "#":
                    nx2, ny2 = x2, y2
                dq.append((nx1, ny1, nx2, ny2, cnt+1))
            elif inRange(nx1, ny1):
                return cnt+1
            elif inRange(nx2, ny2):
                return cnt+1
            else:
                continue
    return -1

def inRange(x, y):
    global row, col
    return 0<=x<row and 0<=y<col

print(bfs())