# https://www.acmicpc.net/problem/11725

from collections import deque

n = int(input())
lst = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

parent = [1]*(n+1)
visited = [False]*(n+1)
dq = deque()
dq.append((1, 1)) #(node, parent)
visited[1] = True
while dq:
    node, par = dq.popleft()
    parent[node] = par
    for i in lst[node]:
        if visited[i] == False:
            visited[i] = True
            dq.append((i, node))

for i in range(2, n+1):
    print(parent[i])