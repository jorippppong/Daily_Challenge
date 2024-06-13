# https://www.acmicpc.net/problem/1789

s = int(input())
sum = 0
num = 0
while sum <= s:
    num += 1
    sum += num

print(num-1)