# https://www.acmicpc.net/problem/2887

# 크루스칼 알고리즘
# 하지만 노드 간의 거리를 다 찾으면 시간 초과가 나기 때문에 최소 거리의 노드들만 추린다. 

def union(x, y):
    x = find(x)
    y = find(y)
    parents[y] = x

def find(x):
    # 부모를 찾을 때까지 진행 (나 = 부모이면 내가 부모이다.)
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

n = int(input())
xlst, ylst, zlst = [], [], [] 
for i in range(n):
    x, y, z = map(int, input().split())
    xlst.append((x, i))
    ylst.append((y, i))
    zlst.append((z, i))

xlst.sort()
ylst.sort()
zlst.sort()

# 인접한 행성들끼리 간선을 구성 (가중치, 행성a, 행성b)
# x, y, z 기준으로 각각 정렬한 뒤 인접한 행성들의 비용을 구해 간선을 구성
edges =[]
for currList in xlst, ylst, zlst:
    for i in range(1, n):
        w1, a = currList[i-1]
        w2, b = currList[i]
        edges.append((abs(w1-w2), a, b))  # (가중치, 행성a, 행성b)
edges.sort(reverse=True)  # 작은 것부터 pop 할것이기 떄문에 내림차순으로 구성

# 크루스칼 진행 (사이클이 존재하면 안된다)
parents = [i for i in range(n)]
cnt, ans = n-1, 0
while cnt:
    w, a, b = edges.pop()
    # 부모가 같으면 cycle이 발생하기 때문에 continue
    if find(a) == find(b):
        continue
    union(a, b)
    cnt -= 1
    ans += w

print(ans)