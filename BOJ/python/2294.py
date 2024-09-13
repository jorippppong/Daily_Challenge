# https://www.acmicpc.net/problem/2294

n, price = map(int, input().split())
coinSet = set([])  # 동전 중복 방지
for _ in range(n):
    coinSet.add(int(input()))
coin = sorted(coinSet)

minCoin = [1e19]*(price+1)
minCoin[0] = 0
for c in coin:
    for p in range(c ,price+1):
        minCoin[p] = min(minCoin[p], minCoin[p-c]+1)

print(minCoin[price] if minCoin[price] != 1e19 else -1)