# https://school.programmers.co.kr/learn/courses/30/lessons/76502

def solution(s):
    length = len(s)
    dictB = {')':'(', '}':'{', ']':'['}
    
    # push : 내가 왼쪽 괄호 (,[,{ 일때
    # pop : 최상단이 나의 짝꿍
    # return 0 : 스텍이 비어 있을 때, pop 하려고 할때 최상단이 나와 다를 때
    def bracket(idx):
        nonlocal length
        stack = []
        for i in range(length):
            curr = (idx+i) % length
            if s[curr] in ['(', '{', '['] :
                stack.append(s[curr])
            else:
                if stack and stack[-1] == dictB[s[curr]]:
                    stack.pop()
                else:
                    return 0
        # 반복문을 다 돌았는데 stack에 괄호가 남아있는 경우
        if stack: return 0
        return 1
        
    answer = 0
    for idx in range(length):
        answer += bracket(idx)
    return answer