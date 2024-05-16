# https://school.programmers.co.kr/learn/courses/30/lessons/42584#

def solution(prices):
    stack = []
    length = len(prices)
    answer = [0] * length
    
    for i in range(length):
        while stack and stack[-1][0] > prices[i]:
            p, idx = stack.pop()
            answer[idx] = i-idx
        stack.append((prices[i], i))
        
    while stack:
        p, idx = stack.pop()
        answer[idx] = length-1 -idx
    
    return answer