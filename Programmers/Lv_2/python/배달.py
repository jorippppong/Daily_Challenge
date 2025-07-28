# https://school.programmers.co.kr/learn/courses/30/lessons/12978

import heapq, math

def solution(N, road, K):
    # 행렬 만들기
    go = [[] for _ in range(N+1)]
    for a, b, value in road:
        go[a].append((b, value)) # (town, 거리)
        go[b].append((a, value))
        
    # 다익스트라
    hq = []
    time = [math.inf, 0] + [math.inf]*(N-1)
    heapq.heappush(hq, (0, 1)) # (거리, 마을번호)
    while hq:
        t, num = heapq.heappop(hq)
        for town, value in go[num]:
            if t + value < time[town]:
                time[town] = t + value
                heapq.heappush(hq, (time[town], town))
    return len([time[i] for i in range(N+1) if time[i]<=K])