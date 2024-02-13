# https://school.programmers.co.kr/learn/courses/30/lessons/42842

import math

def solution(brown, yellow):
    a, b = 0, 0
    # a*b = yellow 
    # (a+2)*(b+2) = brown + yellow
    for i in range(1, math.trunc(math.sqrt(yellow))+1):
        if yellow % i == 0:
            a, b = i, yellow//i
            if (a+2)*(b+2) == (brown + yellow):
                break
    return [b+2, a+2]