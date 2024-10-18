# https://www.acmicpc.net/problem/2252

import collections

n, m = map(int, input().split())
# 키 작은 학생 먼저 출력 
# indegree : 나보다 작은 사람 숫자
indegree = [0]*(n+1)
student = [[] for _ in range(n+1)] # 나보다 큰 사람 저장
dq = collections.deque()
answer = []

for _ in range(m):
    s, l = map(int, input().split())
    indegree[l] += 1
    student[s].append(l)

for i in range(1, n+1):
    if indegree[i] == 0: dq.append(i)
    
while dq:
    s = dq.popleft()
    answer.append(str(s))
    for next in student[s]:
        if indegree[next] > 0: 
            indegree[next] -= 1
            if indegree[next] == 0: 
                dq.append(next)

print(" ".join(answer))