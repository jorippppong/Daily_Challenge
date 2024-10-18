# https://www.acmicpc.net/problem/18353

n = int(input())
lst = list(map(int, input().split()))
dp = [1] * n

# 최대 병사 수를 계산
# dp[i] : i번째 있는 값이 마지막 병사의 전투 값
for i in range(1, n):
    for j in range(0, i):
        if lst[j] > lst[i]:
            dp[i] = max(dp[i], dp[j]+1)

print(n - max(dp))

"""
[15, 11, 4, 8, 5, 2, 4]
[1, 2, 3, 3, 4, 5, 5]
"""