# https://www.acmicpc.net/problem/15654

def perm(cnt):
    global n, m
    if cnt == m:
        print(" ".join(map(str, answer)))
    for i in range(n):
        if visited[i] == False:
            answer.append(lst[i])
            visited[i] = True
            perm(cnt+1)
            num = answer.pop()
            visited[lst.index(num)] = False

n, m = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()
answer = []
visited = [False]*(n)
perm(0)