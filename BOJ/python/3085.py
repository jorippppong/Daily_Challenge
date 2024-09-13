# https://www.acmicpc.net/problem/3085

# 모든 경로의 오른쪽 or 아래와 swap하고 가능한 최대길이 비교
def swap(board, n):
    answer = -1
    # 오른쪽과 swap
    for i in range(n):
        for j in range(n-1):
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            answer = max(answer, maxCandyNum(board, n))
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
    # 아래와 swap
    for i in range(n):
        for j in range(n-1):
            board[j][i], board[j+1][i] = board[j+1][i], board[j][i]
            answer = max(answer, maxCandyNum(board, n))
            board[j][i], board[j+1][i] = board[j+1][i], board[j][i]
    return answer

def maxCandyNum(board, n):
    maxNum = -1
    # 오른쪽으로 진행하면서 비교
    for i in range(n):
        color, count = board[i][0], 1
        for j in range(1, n):
            # 색이 바뀔 때 최대 갯수 갱신
            if color == board[i][j]:
                count += 1
            else:
                maxNum = max(maxNum, count)
                color, count = board[i][j], 1
        # 한 줄이 끝날 때 최대 갯수 갱신
        maxNum = max(maxNum, count)

    # 아래로 진행하면서 비교
    for i in range(n):
        color, count = board[0][i], 1
        for j in range(1, n):
            if color == board[j][i]:
                count += 1
            else:
                maxNum = max(maxNum, count)
                color, count = board[j][i], 1
        maxNum = max(maxNum, count)
    
    return maxNum

n = int(input())
board = [[0]*n for _ in range(n)]
for i in range(n):
    board[i] = list(input())
print(swap(board, n))