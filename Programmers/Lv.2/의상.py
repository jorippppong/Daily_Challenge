# https://school.programmers.co.kr/learn/courses/30/lessons/42578

import collections

def solution(clothes):
    clothD = collections.defaultdict(int)
    for _, type in clothes:
        clothD[type] += 1
    answer = 1
    for v in clothD.values():
        answer *= (v+1)
    return answer - 1