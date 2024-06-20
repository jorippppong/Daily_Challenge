# https://www.acmicpc.net/problem/2667

from collections import deque

def bfs(cnt):
    if not dq:
        x, y = findNextStart()
        if x==n and y==n: return 
        dq.append((x, y))
        visited[x][y] = True
        cnt += 1
    while dq:
        cx, cy = dq.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if inRange(nx, ny) and map[nx][ny] and visited[nx][ny] == False:
                dq.append((nx, ny))
                visited[nx][ny] = True
                cnt += 1

    answer.append(cnt)
    bfs(0)
    return 

def inRange(x, y):
    global n
    return 0<=x<n and 0<=y<n
 
def findNextStart():
    global n
    for i in range(n):
        for j in range(n):
            if map[i][j] and visited[i][j] == False:
                return (i, j)
    return (n, n)

n = int(input())
map = [list(map(int, list(input()))) for _ in range(n)]
answer = []

# 좌우, 위아래 연결
visited = [[False]*n for _ in range(n)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
dq = deque()
bfs(0)

# 결과 출력
answer.sort()
print(len(answer))
for a in answer:
    print(a)