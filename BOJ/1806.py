# https://www.acmicpc.net/problem/1806

N, S  = map(int, input().split())
lst = list(map(int, input().split()))

start, end = 0, 0
sum = 0
answer = 1e19

# sum이 S 보다 작으면 : end++
# sum이 S 보다 크거나 같으면 : start++
while end <= N:
    if sum < S:
        if end == N:
            break
        sum += lst[end]
        end += 1
    else:
        answer = min(answer, end-start)
        sum -= lst[start]
        start += 1

print(answer if answer != 1e19 else 0)