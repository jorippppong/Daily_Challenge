# https://www.acmicpc.net/problem/2293

n, price = map(int, input().split())
coin = [int(input()) for _ in range(n)]
coin.sort()

dp = [0]*(price+1)
dp[0] = 1
for c in coin:
    for p in range(1, price+1):
        if p-c >= 0: dp[p] += dp[p-c]

print(dp[price])