# https://www.acmicpc.net/problem/15650

# 조합(combination)
from itertools import combinations
def comb(cnt):
    if cnt == m:
        print(" ".join(list(map(str, answer))))
        return
    start = answer[-1] if len(answer) > 0 else 0
    for i in range(start+1, n+1):
        answer.append(i)
        comb(cnt+1)
        answer.pop()

def comb_iter():
    global n, m
    a = []
    for lst in combinations(range(1, n+1), m):
        a.append(list(lst))

    for lst in a:
        print(" ".join(list(map(str, lst))))

n, m = map(int, input().split())
answer = []
comb(0)
comb_iter()