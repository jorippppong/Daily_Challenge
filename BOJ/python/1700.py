# https://www.acmicpc.net/problem/1700

from collections import defaultdict, deque

n, k = map(int, input().split())
lst = list(map(int, input().split()))
tab = set()
answer = 0

# 다음에 등장하는 시간을 기점으로 계산 (가장 늦은게 out)
order = defaultdict(deque)
for i, l in enumerate(lst):
    order[l].append(i)

def findLatest():
    latestOrder = -1
    latestNum = -1
    for t in tab:
        # 더 이상 등장할 일이 없음 (당장 제외)
        if len(order[t]) == 0:
            return t
        elif order[t][0] > latestOrder:
            latestOrder = order[t][0]
            latestNum = t
    return latestNum

for num in lst:
    if len(tab) < n:
        tab.update([num])
    else:
        if num not in tab:
            latestNum = findLatest()
            tab.remove(latestNum)
            tab.update([num])
            answer += 1
    order[num].popleft()

print(answer)