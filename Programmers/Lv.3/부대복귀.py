# https://school.programmers.co.kr/learn/courses/30/lessons/132266

import math, heapq

def solution(n, roads, sources, destination):
    # 인접 리스트 만들기
    road = [[] for _ in range(n+1)]
    for a,b in roads:
        road[a].append(b)
        road[b].append(a)
    
    # 다익스트라로 최소 거리 찾기 (destination ~ ...)
    weight = [math.inf] * (n+1)
    weight[destination] = 0
    
    hq = []
    heapq.heappush(hq, (0, destination)) # 거리, 현위치
    while hq:
        w, now = heapq.heappop(hq)
        # 여기 무조건 > (>=로 쓰면 안됨 왜냐하면 출발지 정보 꺼낼때 조건 만족 못하면서 정답 도출을 못함) 근데 여기 if 조건 삭제해도 정답은 똑같음
        if w > weight[now]:
            continue
        for idx in road[now]:
            cost = weight[now] + 1
            if cost < weight[idx]:
                weight[idx] = cost
                heapq.heappush(hq, (cost, idx))
        
    # 정답 출력
    answer = []
    for idx in sources:
        if weight[idx] == math.inf:
            answer.append(-1)
        else:
            answer.append(weight[idx])
    return answer