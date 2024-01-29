# https://school.programmers.co.kr/learn/courses/30/lessons/12987

def solution(A, B):
    A.sort(reverse = True)
    B.sort(reverse = True)
    a, b, score = 0, 0, 0
    length = len(A)
    for _ in range(length):
        if a==length:
            return
        if B[b] > A[a]:
            score += 1
            b+=1
        a+=1
    return score