# https://school.programmers.co.kr/learn/courses/30/lessons/12938

def solution(n, s):
    if(n>s):
        return [-1]
    share, remainder = s//n, s%n
    return [share] * (n - remainder) + [share+1] * (remainder)