# https://www.acmicpc.net/problem/17070

### 1️⃣ DP ###
def solution(n, board):
    dp = [[[0] * n for _ in range(n)] for _ in range(3)]  # [dir][x][y]
    dp[0][0][1] = 1
    for i in range(2, n):
        if board[0][i]==0:
            dp[0][0][i] = dp[0][0][i-1]
    
    for i in range(1, n):
        for j in range(1, n):
            if board[i][j] == 0:
                # 가로 방향
                dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]
                # 세로 방향
                dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]
                # 대각선 방향
                if board[i-1][j] == 0 and board[i][j-1] == 0:
                    dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]
    
    return dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
print(solution(n, board))


### 2️⃣ BackTracking - 70% 통과 후 시간초과 발생 ###
def BT(x, y, dir):
    global answer, n
    if x==n-1 and y==n-1:
        answer += 1
        return 
    for i in range(3):
        if (dir==0 and i==1) or (dir==1 and i==0):
            continue
        nx = x + dx[i]
        ny = y + dy[i]
        if inRange(nx, ny) and canGo(nx, ny, i):
            BT(nx, ny, i)

def inRange(x, y):
    global n
    return 0<=x<n and 0<=y<n

def canGo(nx, ny, dir):
    if dir==0 or dir==1:
        return road[nx][ny] != 1
    else:
        if road[nx][ny] or road[nx-1][ny] or road[nx][ny-1]:
            return False
        else:
            return True

n = int(input())
road = [list(map(int, input().split())) for _ in range(n)]
# [가로, 세로, 대각선]
dx = [0, 1, 1]
dy = [1, 0, 1]

answer = 0
BT(0, 1, 0)
print(answer)