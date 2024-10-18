# https://www.acmicpc.net/problem/1038

# 중복 없이, 순서 상관 O
def permutation(lst, n, r):
    def choose(cnt):
        if cnt == r:
            print(a)
            return
        for i in range(n):
            if visited[i] == False:
                a.append(lst[i])
                visited[i] = True
                choose(cnt+1)
                a.pop()
                visited[i] = False
    
    visited = [False]*n
    a = []
    choose(0)

# 중복 없이, 순서 상관 X
def combination(lst, n, r):
    lst.sort()
    def choose(cnt):
        if cnt == r:
            print(a)
            return
        start = lst.index(a[-1])+1 if a else 0
        for i in range(start, n):
            a.append(i)
            choose(cnt+1)
            a.pop()

    a = []
    choose(0)

lst = [0, 1, 2]
r = 2
permutation(lst, len(lst), r)
combination(lst, len(lst), r)