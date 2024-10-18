# https://www.acmicpc.net/problem/15652

from itertools import combinations_with_replacement

# 중복 가능한 조합
def comb_dup(cnt):
    global n, m
    if cnt == m:
        print(" ".join(map(str, answer)))
        return
    start = answer[-1] if len(answer)>0 else 1
    for i in range(start, n+1):
        answer.append(i)
        comb_dup(cnt+1)
        answer.pop()

def comb_dup_iter():
    global n, m
    a = []
    for lst in combinations_with_replacement(range(1, n+1), m):
        a.append(list(lst))
    a.sort()
    for lst in a:
        print(" ".join(map(str, lst)))
          
n, m = map(int, input().split())
answer = []
comb_dup(0)
comb_dup_iter()