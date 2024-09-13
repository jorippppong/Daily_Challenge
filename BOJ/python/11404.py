# https://www.acmicpc.net/problem/11404

import math

def solution(city, lst):
    # 1. 인접행렬
    dp = [[math.inf]*(city+1) for _ in range(city+1)]
    for a, b, c in lst:
        dp[a][b] = min(c, dp[a][b])
    for i in range(1, city+1):
        dp[i][i] = 0

    # 2. 
    for k in range(1, city+1):
        for i in range(1, city+1):
            for j in range(1, city+1):
                dp[i][j] = min(dp[i][j], dp[i][k]+dp[k][j])

    # 결과 출력
    for i in range(1, city+1):
        answer = []
        for j in range(1, city+1):
            answer.append(str(dp[i][j]) if dp[i][j] != math.inf else "0")
        print(" ".join(answer))

city = int(input())
bus = int(input())
lst = [map(int, input().split()) for _ in range(bus)]
solution(city, lst)