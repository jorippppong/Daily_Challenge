# https://www.acmicpc.net/problem/15486

import sys
input = sys.stdin.readline

n = int(input())
work = [list(map(int, input().split())) for _ in range(n)]

cost = [0]*(n+1)
for i in range(n):
    cost[i] = max(cost[i], cost[i-1])
    if i + work[i][0] <= n:
        cost[i + work[i][0]] = max(cost[i + work[i][0]], cost[i]+work[i][1])

print(max(cost))