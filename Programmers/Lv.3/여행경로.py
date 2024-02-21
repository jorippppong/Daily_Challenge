# https://school.programmers.co.kr/learn/courses/30/lessons/43164

import collections

answer = []
country = collections.defaultdict(list)

def DFS(key):
    while country[key]:
        DFS(country[key].pop(0))
    
    if not country[key]:
        answer.append(key)
        return

def solution(tickets):
    # 인접 행렬 만들기
    for a, b in tickets:
        country[a].append(b)
    for a, _ in country.items():
        country[a].sort()
    
    DFS("ICN")
    return answer[::-1]
    
# 새로 알게된 지식 : collections.defaultdict(list)