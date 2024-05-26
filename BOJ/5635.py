# https://www.acmicpc.net/problem/5635

n = int(input())
lst = [input().split() for _ in range(n)]
for i in range(n):
    for j in range(1, 4):
        lst[i][j] = int(lst[i][j])

lst.sort(key=lambda x:(x[3], x[2], x[1]))
print(lst[n-1][0])
print(lst[0][0])