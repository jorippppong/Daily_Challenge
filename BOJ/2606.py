# https://www.acmicpc.net/problem/2606

import collections

def solution(N, lst):
    network = [[] for _ in range(N+1)]
    for a, b in lst:
        network[a].append(b)
        network[b].append(a)
    
    visited = [False]*(N+1)
    dq = collections.deque()
    dq.append(1)
    while dq:
        com = dq.popleft()
        visited[com] = True
        for next in network[com]:
            if not visited[next]:
                dq.append(next)
    return len([i for i in range(2, N+1) if visited[i]])

N, M = int(input()), int(input())
lst = [list(map(int, input().split())) for _ in range(M)]
print(solution(N, lst))