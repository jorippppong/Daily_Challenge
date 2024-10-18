# https://www.acmicpc.net/problem/1038

from itertools import combinations

n = int(input())
answer = []

# 최소 감소하는 수 : 0, 최대 감소하는 수 : 9876543210
for i in range(1, 11):
    for lst in combinations(range(10), i):
        num = sorted(list(lst), reverse=True)
        answer.append(int("".join(map(str, num))))

answer.sort()
print(answer[n] if n < len(answer) else -1)