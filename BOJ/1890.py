# https://www.acmicpc.net/problem/1890

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0
dx, dy = [0, 1], [1, 0]

def inRange(x, y):
    global n
    return 0<=x<n and 0<=y<n

### DP ###
dp = [[0]*n for _ in range(n)]
dp[0][0] = 1
for i in range(n):
    for j in range(n):
        if dp[i][j] == 0 or board[i][j] ==0: continue
        for k in range(2):
            nx, ny = i+(dx[k] * board[i][j]), j+(dy[k] * board[i][j])
            if inRange(nx, ny):
                dp[nx][ny] += dp[i][j]                

print(dp[-1][-1])


### DFS ###
def dfs(x, y):
    global answer
    if x==n-1 and y==n-1:
        answer += 1
        return
    if board[x][y] == 0:
        return
    for i in range(2):
        nx, ny = x+(dx[i] * board[x][y]), y+(dy[i] * board[x][y])
        if inRange(nx, ny):
            dfs(nx, ny)

# dfs(0, 0)
# print(answer)