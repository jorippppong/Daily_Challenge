# https://www.acmicpc.net/problem/16916

### KMP : 문자열 검색 알고리즘 ###
def makePi(p):
    j = 0
    pi = [0]*len(p)
    for i in range(1, len(p)):
        while j>0 and p[i] != p[j]:
            j = pi[j-1]
        if p[i] == p[j]:
            j += 1
            pi[i] = j
    return pi

def kmp(s, p):
    pi = makePi(p)
    j = 0
    for i in range(len(s)):
        while j>0 and s[i] != p[j]:
            j = pi[j-1]
        if s[i] == p[j]:
            if j == len(p)-1:
                return 1
            else:
                j+=1
    return 0

str, pattern = input(), input()
print(kmp(str, pattern))

### 파이썬 내장 함수 사용 ###
# print(1 if pattern in str else 0)