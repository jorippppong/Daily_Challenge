# https://school.programmers.co.kr/learn/courses/30/lessons/12979

import math

def solution(n, stations, w):
    start = 1
    answer = 0
    width = 2*w + 1
    for num in stations:
        end = num-w
        answer += math.ceil((end-start)/width)
        start = num+w+1
    if(start <= n):
        answer += math.ceil((n+1 - start)/width)
    return answer