# https://school.programmers.co.kr/learn/courses/30/lessons/152995

def solution(scores):
    wanHo = scores[0]
    scores.sort(key = lambda x : (-x[0], x[1]))
    maxNum = scores[0][1]
    rank = 1
    for a, b in scores:
        if b < maxNum:
            if a == wanHo[0] and b == wanHo[1]:
                return -1 
        else: 
            if a+b > wanHo[0]+wanHo[1]:
                rank += 1
        maxNum = max(maxNum, b)
    return rank

"""
개삽질한 잘못된 코드...ㅜㅜ 내 한시간 반....
"""
import heapq

def solution2(scores):
    # 인센티브 받을 수 있는지 없는지 계산 
    heap, maxH = [], []
    canGet = [False] * (len(scores))
    for i, s in enumerate(scores):
        heapq.heappush(heap, ((s[0], s[1]), i))
        heapq.heappush(maxH, -s[1])
    
    maxNum = 0
    deleteNum = []
    while heap:
        s, i = heapq.heappop(heap)
        maxNum = -heapq.heappop(maxH)
        
        while deleteNum:
            deleteMax = -heapq.heappop(deleteNum)
            if deleteMax > maxNum:
                continue
            elif deleteMax == maxNum:
                maxNum = -heapq.heappop(maxH)
            else:
                heapq.heappush(deleteNum, -deleteMax)
                break
                
        if s[1] == maxNum:
            canGet[i] = True
        else:
            heapq.heappush(maxH, -maxNum)
            heapq.heappush(deleteNum, -s[1])
    
    # 결과 계산
    if not canGet[0]:
        return -1 
    
    final= []
    for i, s in enumerate(scores):
        if canGet[i]:
            heapq.heappush(final, (-(s[0]+s[1]), i))
    rank = 1
    prevS = 0
    accum = 1
    top = final[0][1]
    while final:
        s, i = heapq.heappop(final)
        if i == top:
            prevS = s
        else: 
            if s == prevS:
                accum += 1
            else:
                rank += accum
                accum = 1
        if i == 0:
            return rank