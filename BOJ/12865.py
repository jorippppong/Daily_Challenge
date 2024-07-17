# https://www.acmicpc.net/problem/12865

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
bag = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,K+1):
        if j >= bag[i-1][0]:  # 현재최대무게j가 해당물건무게보다 큰 경우
        #표의 윗 셀의 값과 현재물건의V+이전물건의V값의 최댓값을 DP[i][j]에 저장
            dp[i][j] = max(bag[i-1][1]+dp[i-1][j-bag[i-1][0]],dp[i-1][j])
        else:
        	# 현재최대무게j가 해당물건무게보다 작은 경우 (현재 물건을 담을 수 없는 경우)
            dp[i][j] = dp[i-1][j]

print(dp[N][K])