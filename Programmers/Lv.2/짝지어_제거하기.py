# https://school.programmers.co.kr/learn/courses/30/lessons/12973

def solution(s):
    stack = []
    for i in range(len(s)):
        # 비어 있으면 무조건 값 추가
        if not stack:
            stack.append(s[i])
        elif stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])
    return 0 if stack else 1