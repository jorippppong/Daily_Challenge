# https://www.acmicpc.net/problem/1717

import sys
sys.setrecursionlimit(1000000)

n, m = map(int, input().split())
opers = [map(int, input().split()) for _ in range(m)]
parent = [i for i in range(n+1)]

def find(x):
    if parent[x] == x:
        return parent[x]
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    parentX = find(x)
    parentY = find(y)
    if parentX != parentY:
       parent[max(parentX, parentY)] = min(parentX, parentY)

for o, a, b in opers:
    # 합집합 
    if o == 0:
        union(a, b)
    # 두 원소가 같은 집합에 포함되어 있는지 확인
    elif o == 1:
        if(find(a) == find(b)): print("YES")
        else: print("NO")