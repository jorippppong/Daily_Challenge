# https://www.acmicpc.net/problem/4485

import math, heapq

count = 0
while True:
    n = int(input())
    if n == 0:break
    cave = [list(map(int, input().split())) for _ in range(n)]
    
    count += 1
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    weight = [[math.inf]*n for _ in range(n)]
    weight[0][0] = cave[0][0]
    hq = []
    heapq.heappush(hq, (weight[0][0], 0, 0))  # weight, x, y
    while hq:
        w, currX, currY = heapq.heappop(hq)
        if w > weight[currX][currY]:
            continue
        for i in range(4):
            nextX, nextY = currX + dx[i], currY + dy[i]
            if 0<=nextX<n and 0<=nextY<n:
                cost = w + cave[nextX][nextY]
                if cost < weight[nextX][nextY]:
                    weight[nextX][nextY] = cost
                    heapq.heappush(hq, (cost, nextX, nextY))
    print("Problem %d: %d" %count %weight[n-1][n-1])