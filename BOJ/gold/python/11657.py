# https://www.acmicpc.net/problem/11657

import math 

n, m = map(int, input().split())
lst = []
for _ in range(m):
    lst.append(list(map(int, input().split())))

road = [math.inf]*(n+1)
road[1] = 0
def bellman_ford():
    for i in range(n):
        for s, e, c in lst:
            if road[s] != math.inf and road[s]+c < road[e]:
                road[e] = road[s]+c
                if i ==n-1: return False
    return True

canGo = bellman_ford()
if canGo:
    for i in range(2, n+1):
        print(road[i] if road[i]!=math.inf else -1)
else:
    print(-1)