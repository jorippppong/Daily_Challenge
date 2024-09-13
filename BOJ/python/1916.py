# https://www.acmicpc.net/problem/1916

import heapq, math, sys

input = sys.stdin.readline
n, m = int(input()), int(input())
lst = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, cost = map(int, input().split())
    lst[a].append((b, cost))  # (목적지, 가격)
start, end = map(int, input().split())

hq = []
cost = [math.inf]*(n+1)
cost[start] = 0
heapq.heappush(hq, (0, start)) # (가격, 도시)
while hq:
    money, city = heapq.heappop(hq)
    if cost[city] < money:
        continue
    for info in lst[city]:
        if info[1]+money < cost[info[0]]:
            cost[info[0]] = info[1]+money
            heapq.heappush(hq, (cost[info[0]], info[0]))
print(cost[end])