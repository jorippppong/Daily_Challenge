# https://www.acmicpc.net/problem/1260

from collections import deque

def DFS(n, start, road):
    def move(node):
        for i in road[node]:
            if visited[i] == False:
                answer.append(str(i))
                visited[i] = True
                move(i)
    answer = [str(start)]
    visited = [False]*(n+1)
    visited[start] = True
    move(start)
    print(" ".join(answer))

def BFS(n, start, road):
    answer = []
    dq = deque()
    dq.append(start)
    visited = [False]*(n+1)
    visited[start] = True
    while dq: 
        node = dq.popleft()
        answer.append(str(node))
        for i in road[node]:
            if visited[i] == False:
                dq.append(i)
                visited[i] = True
    print(" ".join(answer))

n, m, start = map(int, input().split())
road = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)
for i in range(1, n+1):
    road[i].sort()

DFS(n, start, road)
BFS(n, start, road)