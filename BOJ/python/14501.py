# https://www.acmicpc.net/problem/14501

def calculate():
    global answer
    totalCost = [work[i][1] for i in idxs]
    answer = max(answer, sum(totalCost))

def backtracking(today):
    if(today == n):
        calculate()
    for t in range(today, n):
        if t + work[t][0] <= n:
            idxs.append(t)
            backtracking(t + work[t][0])
            idxs.pop()
        else:
            calculate()

n = int(input())
work = [list(map(int, input().split())) for _ in range(n)]
idxs = []
answer = 0
backtracking(0)
print(answer)