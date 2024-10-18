# https://www.acmicpc.net/problem/1303

from collections import deque
import sys

sys.setrecursionlimit(10000)
col, row = map(int, input().split())
lst = [input() for _ in range(row)]
score = {"W": 0, "B":0}

def notVisited():
    global row, col
    for i in range(row):
        for j in range(col):
            if visited[i][j] == False:
                return (i, j)
    return (row, col)

def inRange(x, y):
    global row, col
    return 0<=x<row and 0<=y<col

def calcalate():
    x, y = notVisited()
    if x==row and y==col:
        return
    cnt, team = 0, lst[x][y]
    dq = deque()
    dq.append((x, y))
    visited[x][y] = True
    while dq:
        x, y = dq.popleft()
        cnt += 1
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if inRange(nx, ny) and visited[nx][ny] == False and lst[x][y] == lst[nx][ny]:
                dq.append((nx, ny))
                visited[nx][ny] = True
    score[team] += cnt**2
    calcalate()

visited = [[False]*col for _ in range(row)]
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
calcalate()
print(str(score["W"]) + " "+ str(score["B"]))