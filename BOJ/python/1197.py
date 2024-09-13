# https://www.acmicpc.net/problem/1197

# 가중치를 최소로 정렬(heapq), union-find(no-cycle)
import heapq

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    parentX = find(x)
    parentY = find(y)
    if parentX != parentY:
        parent[max(parentX, parentY)] = min(parentX, parentY)

hq = []
V, E = map(int, input().split())
parent = [i for i in range(V+1)]
for _ in range(E):
    a, b, value = map(int, input().split())
    heapq.heappush(hq, (value, a, b))

sum = 0
while hq:
    value, a, b = heapq.heappop(hq)
    # cycle이 발생하면 pass
    if find(a) == find(b):
        continue
    sum += value
    union(a, b)
print(sum)