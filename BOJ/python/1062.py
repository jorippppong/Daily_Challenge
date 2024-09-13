# https://www.acmicpc.net/problem/1062

import sys

n, k = map(int, input().split())

# k 가 5보다 작으면 어떤 언어도 배울 수 없음
if k < 5:
    print(0)
    exit()
# k 가 26이면 모든 언어를 배울 수 있음
elif k == 26:
    print(n)
    exit()

answer = 0
words = [set(sys.stdin.readline().rstrip()) for _ in range(n)]
learn = [0] * 26

# 적어도 언어 하나는 배우기위해 a,c,i,n,t 는 무조건 배워야함
for c in ('a', 'c', 'i', 'n', 't'):
    learn[ord(c) - ord('a')] = 1

def dfs(idx, cnt):
    global answer

    if cnt == k - 5:
        readcnt = 0
        for word in words:
            check = True
            for w in word:
                if not learn[ord(w) - ord('a')]:
                    check = False
                    break
            if check:
                readcnt += 1
        answer = max(answer, readcnt)
        return

    for i in range(idx, 26):
        if not learn[i]:
            learn[i] = True
            dfs(i, cnt + 1)
            learn[i] = False

dfs(0, 0)
print(answer)


# def solution(n, k):
#     global newAlpha, defaultAlpha
#     if k < 5: return 0
#     if k > 26: return n
    
#     # 1. 기존에 있는 단어들에서 a,n,t,i,c 제거, 새로운 알파벳 추출
#     for i in range(n):
#         newAlpha.update(words[i])
#     newAlpha = newAlpha - defaultAlpha

#     # 2. 새로운 알파벳 k-5개로 가능한 조합 생성
#     k -= 5
#     if k == 0: return len([w for w in words if len(w)==0])
#     BT(0, k)
#     return maxNum

# # 완전탐색 (backtracking)
# def BT(num, k):
#     global maxNum, newAlpha, combination
#     if num == k:
#         # 최대 갱신
#         maxNum = max(maxNum, countN(combination))
#         return
#     for a in newAlpha:
#         if not visited[ord(a)-97]:
#             combination.add(a)
#             visited[ord(a)-97] = True
#             BT(num+1, k)
#             combination.remove(a)
#             visited[ord(a)-97] = False

# # n에 해당하는 횟수 계산
# def countN(combination):
#     cnt = 0
#     for word in words:
#         flag = True
#         for w in word:
#             if w not in combination and w not in defaultAlpha: flag = False
#         if flag: cnt += 1
#     return cnt

# n, k = map(int, input().split())
# words = [input().strip()[4:-4] for _ in range(n)] # 'anta'와 'tica' 제거
# maxNum = 0
# combination = []
# visited = [False]*(27)
# defaultAlpha = set(['a','n','t','i','c'])
# for c in ('a', 'c', 'i', 'n', 't'):
#     visited[ord(c) - ord('a')] = True
# newAlpha = set()
# combination = set()
# print(solution(n,k))