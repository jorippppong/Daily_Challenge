# https://school.programmers.co.kr/learn/courses/30/lessons/138476

from collections import defaultdict, Counter

# Counter 사용
def solution(k, tangerine):
    answer = 0
    tanCount = Counter(tangerine)
    sortedTan = sorted(tanCount.items(), key = lambda x:-x[1])
    while k > 0:
        k -= sortedTan[answer][1]
        answer += 1
    return answer
    
# Dictionary 사용 
def solution2(k, tangerine):
    answer = 0
    tDict = defaultdict(int)
    for size in tangerine:
        tDict[size] += 1
    sortedF = sorted(tDict.items(), key = lambda x : -x[1])
    while k > 0:
        k -= sortedF[answer][1]
        answer += 1
    return answer