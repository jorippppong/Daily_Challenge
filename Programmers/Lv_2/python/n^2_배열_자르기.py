# https://school.programmers.co.kr/learn/courses/30/lessons/87390

def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        x, y = i//n, i%n
        answer.append(max(x,y)+1)
    return answer