# https://school.programmers.co.kr/learn/courses/30/lessons/42626

import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while len(scoville) >= 2 and scoville[0] < K:
        a, b = heapq.heappop(scoville), heapq.heappop(scoville)
        heapq.heappush(scoville, a + b*2)
        answer += 1
    if scoville[0] < K:
        return -1
    else:
        return answer