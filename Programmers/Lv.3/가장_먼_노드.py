# https://school.programmers.co.kr/learn/courses/30/lessons/49189

from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]  # 인접리스트
    visited = [0] * (n+1) # 1로 부터 얼마나 떨어져 있는지 저장
    
    # 간선을 인접리스트로 변경
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    # BFS 
    queue = deque()
    queue.append(1)
    visited[1] = 1
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = visited[node] + 1
                queue.append(i)
    
    # 결과 출력
    maxValue = max(visited)
    return visited.count(maxValue)

# 최단 경로로 따짐 (5의 경우 최단 :2, 최대 : 3) 따라서 BFS 가능
# 7,8,9 타임 에러 이유 : for 문을 전체로 다 돌림 (for i in range(2, n+1)) & if 문에 i in graph[node] 작성
# 이렇게 하니까 20,000개의 노드를 다 돌면서 시간이 많이 소요됨