# https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if not stack:
                return False
            else: stack.pop()
    return not stack