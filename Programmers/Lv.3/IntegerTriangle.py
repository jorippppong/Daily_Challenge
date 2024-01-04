def solution(triangle):
    dp = []
    h = len(triangle)
    for i in range(h):
        dp.append([0] * (i+1))
    # dp 초기화
    dp[0][0] = triangle[0][0]
    for i in range(1, h):
        dp[i][0] = dp[i-1][0] + triangle[i][0]
        dp[i][-1] = dp[i-1][-1] + triangle[i][-1]
    # dp 완성
    for i in range(2, h):
        for j in range(1, i):
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
    return max(dp[h - 1])