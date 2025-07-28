# https://school.programmers.co.kr/learn/courses/30/lessons/68646

"""
번호가 작은 풍선을 제거하는 행위는 최대 1번! O(n)
x가 살아남을 수 있다 :
    1. 내가 리스트에서 가장 작은 숫자
    2. 계속 큰 풍선만 제거함(각 방향에서 min 값) & 작은 풍선 제거하기 1번
        a. (minA 나) minB -> minA < 나 < minB, minA > 나 > minB
        b. minA (나 minB) -> minA < 나 < minB, minA > 나 > minB
        c. '나'가 양 끝에 있는 경우 : 내가 minA, minB보다 큼
        : 각 방향에서의 min 값을 저장하는 리스트 필요 
"""
import math

def solution(a):
    length = len(a)
    leftMin, rightMin = [0] * length, [0]*length
    leftMin[0] = a[0]
    rightMin[-1] = a[-1]
    totalMin = min(a)
    
    # leftMin
    for i in range(1, length):
        leftMin[i] = min(leftMin[i-1], a[i])
    # rightMin
    for i in range(length-2, -1, -1):
        rightMin[i] = min(rightMin[i+1], a[i])
    
    answer = 0
    for i in range(length):
        # 1.
        if a[i] == totalMin:
            answer += 1
            continue
        # 2. 
        if i == 0:
            if a[i] > rightMin[i+1]:
                answer += 1
            continue
        elif i == length-1:
            if a[i] > leftMin[i-1]:
                answer += 1
            continue
        elif leftMin[i-1]<a[i]<rightMin[i+1] or leftMin[i-1]>a[i]>rightMin[i+1]:
            answer += 1
    
    return answer