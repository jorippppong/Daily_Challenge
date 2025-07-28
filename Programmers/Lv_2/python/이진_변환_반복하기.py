# https://school.programmers.co.kr/learn/courses/30/lessons/70129

def solution(s):
    answer = [0, 0]
    while len(s) != 1:
        s = format(len(s) - (zeros := s.count("0")), 'b')
        answer[0] += 1 
        answer[1] += zeros
    return answer