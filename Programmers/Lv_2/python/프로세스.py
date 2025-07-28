# https://school.programmers.co.kr/learn/courses/30/lessons/42587

from collections import deque

def solution(priorities, location):
    count = 0
    dq = deque()
    maxLst = []
    for i, p in enumerate(priorities):
        dq.append((i, p))
        maxLst.append(p)
    maxLst.sort()
    
    while True:
        i, p = dq.popleft()
        if p < maxLst[-1]:
            dq.append((i, p))
        else:
            count += 1
            maxLst.pop()
            if i == location:
                return count
                break
                
# location 번째가 몇번에 출력되냐...
# input : priorities = [2, 1, 3, 2]
# dq = deque([(0, 2), (1, 1), (2, 3), (3, 2)])
# maxLst = [1, 2, 2, 3]