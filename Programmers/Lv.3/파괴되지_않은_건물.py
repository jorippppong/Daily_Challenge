# https://school.programmers.co.kr/learn/courses/30/lessons/92344

def solution(board, skill):
    # 입력 
    n, m = len(board), len(board[0])
    # 누적 합
    accumulate = [[0] * (m+1) for _ in range(n+1)]
    for t, r1, c1, r2, c2, d in skill:
        if t == 1: d = -d
        accumulate[r1][c1] += d
        accumulate[r2+1][c1] -= d
        accumulate[r1][c2+1] -= d
        accumulate[r2+1][c2+1] += d
    
    # 위 -> 아래로 값 전파
    for j in range(m):
        for i in range(n):
            accumulate[i+1][j] += accumulate[i][j]    
    # 왼쪽 -> 오른쪽으로 값 전파
    for i in range(n):
        for j in range(m):
            accumulate[i][j+1] += accumulate[i][j]
    
    # 스킬 + 초기 상태 = 최종 상태 
    answer = 0
    for i in range(n):
        for j in range(m):
            if accumulate[i][j] + board[i][j] >= 1:
                answer += 1
    
    return answer