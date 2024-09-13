# https://www.acmicpc.net/problem/2096

from collections import deque

n = int(input())
minDP, maxDP = deque(), deque()
for i in range(n):
    arr = list(map(int, input().split()))
    if i==0:
        minDP.append(arr)
        maxDP.append(arr)
        continue
    min0 = min(minDP[0][0], minDP[0][1]) + arr[0]
    min1 = min(minDP[0][0], minDP[0][1], minDP[0][2]) + arr[1]
    min2 = min(minDP[0][1], minDP[0][2]) + arr[2]
    minDP.pop()
    minDP.append([min0, min1, min2])

    max0 = max(maxDP[0][0], maxDP[0][1]) + arr[0]
    max1 = max(maxDP[0][0], maxDP[0][1], maxDP[0][2]) + arr[1]
    max2 = max(maxDP[0][1], maxDP[0][2]) + arr[2]
    maxDP.pop()
    maxDP.append([max0, max1, max2])

print(str(max(maxDP[0])) + " " + str(min(minDP[0])))