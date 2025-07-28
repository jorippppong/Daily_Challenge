# https://school.programmers.co.kr/learn/courses/30/lessons/12927

# O(nlogn) : 효율성 성공
import heapq
def solution(n, works):
    heapq.heapify(works := [-i for i in works]) # max 힙, := 는 할당 연산자
    for i in range(min(n, abs(sum(works)))):
        heapq.heappush(works, heapq.heappop(works)+1)
    return sum([i**2 for i in works])


'''
# 총 O(n^2) : 효율성 실패 
def solution(n, works):
    if sum(works) <= n:
        return 0
    for i in range(n):
        maxNum = max(works)
        works.remove(maxNum)  # O(n)
        maxNum -= 1
        works.append(maxNum)
    return sum([i**2 for i in works])
'''