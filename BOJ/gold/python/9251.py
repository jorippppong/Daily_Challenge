# https://www.acmicpc.net/problem/9251

s1, s2 = input(), input()
len1, len2 = len(s1), len(s2)
len = [[0]*(len2+1) for _ in range(len1+1)]
for i in range(1, len1+1):
    for j in range(1, len2+1):
        if s1[i-1] == s2[j-1]:
            len[i][j] = len[i-1][j-1] + 1
        else:
            len[i][j] = max(len[i-1][j], len[i][j-1])
print(len[-1][-1])