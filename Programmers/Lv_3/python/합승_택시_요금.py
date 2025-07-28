# https://school.programmers.co.kr/learn/courses/30/lessons/72413

import math

def solution(n, s, a, b, fares):
    # 1. 인접 행렬 만들기
    maxNum = math.inf
    lst = [[maxNum]*(n+1) for _ in range(n+1)]
    for i, j, weight in fares:
        lst[i][j] = weight
        lst[j][i] = weight
    for i in range(1, n+1):
        lst[i][i] = 0

    # 2. 플로이드 알고리즘 사용해서 각 루트의 최단 경로를 완성
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                lst[i][j] = min(lst[i][j], lst[i][k]+lst[k][j])
                
    # s -> i 의 값이 존재 x 하는 경우 : s -> a, b의 각 값을 구해서 그 합을 저장
    # s -> i 의 값이 존재하는 경우 : i -> a, b가 둘다 존재 할 때의 값 저장
    answer = [lst[s][a] + lst[s][b]]
    for idx in range(1, n+1):
        if idx == s: continue
        if lst[s][idx] != maxNum:
            if lst[idx][a] != maxNum and lst[idx][b] != maxNum:
                cost = lst[s][idx] + lst[idx][a] + lst[idx][b]
                answer.append(cost)
            
    return min(answer)