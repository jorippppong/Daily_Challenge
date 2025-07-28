# https://school.programmers.co.kr/learn/courses/30/lessons/43164

import collections

answer = []
country = collections.defaultdict(list)

def DFS(key):
    while country[key]:
        DFS(country[key].pop(0))
    
    # pop(0)을 다시 재귀로 넣는다.(거꾸로 들어가기 때문에 출력할때 거꾸로 해줘야 함)
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


"""
answer = []
graph = collections.defaultdict(list)
visited = collections.defaultdict(list)

def dfs(s, cnt, list, l):
    if cnt == l:
        answer.append(list)
        return
    
    if len(answer) >= 1:
        return

    for a in range(len(graph[s])):
        if visited[s][a] == 0:
            visited[s][a] = 1
            dfs(graph[s][a], cnt+1, list+[graph[s][a]], l)
            visited[s][a] = 0

def solution(tickets):
    
    for a,b in tickets:
        graph[a].append(b)
        visited[a].append(0)
    for a, b in graph.items():
        graph[a].sort()

    dfs("ICN",0, ["ICN"], len(tickets))

    return answer[:][0]
"""