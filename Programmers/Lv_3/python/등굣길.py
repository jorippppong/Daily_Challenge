# https://school.programmers.co.kr/learn/courses/30/lessons/42898

def solution(m, n, puddles):
    dp = [[0] * (m+1) for _ in range(n+1)]
    for x in range(n+1):
        for y in range(m+1):
            if x==1 and y==1:
                dp[x][y] = 1
            elif [y, x] not in puddles:
                dp[x][y] = dp[x][y-1] + dp[x-1][y]
    return dp[n][m] % 1000000007  
    # %1000000007를 안붙이면 효율성이 다 탈락하는 정말 아주 매우 놀라운 결과... 기준이 뭘까;;

# Backtracking : 시간 초과 오류 발생, O(2^(m+n))
def solution1(m, n, puddles):
    def inRange(x, y):
        nonlocal m, n
        # puddle인지 아닌지, 값이 범위를 벗어나는지 아닌지
        return x<=m and y<=n and [x,y] not in puddles
    def move(x, y):
        nonlocal result, m, n
        if(not inRange(x,y)):
            return
        if x==m and y==n:
            result+=1
            return
        move(x+1, y)
        move(x, y+1)
    result = 0
    move(1, 1)
    return result