# https://www.acmicpc.net/problem/1922

import sys
sys.setrecursionlimit(1000)

n, m = int(input()), int(input())
coms = [list(map(int, input().split())) for _ in range(m)]  # a, b, cost
coms.sort(key = lambda x:x[2]) # cost가 오름차순이 되도록 정렬 
parent = [i for i in range(n+1)]
total = 0

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]
    
def union(x, y):
    parentX = find(x)
    parentY = find(y)
    if parentX != parentY:
        parent[max(parentX, parentY)] = min(parentX, parentY)

for a, b, cost in coms:
    # 사이클 생성 방지
    if(find(a) == find(b)):
        continue
    union(a, b)
    total += cost

print(total)