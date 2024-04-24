# https://school.programmers.co.kr/learn/courses/30/lessons/17677

from collections import defaultdict
import math

def solution(str1, str2):
    ### 문자열 2글자로 끊어서 집합 만들기
    str1D = defaultdict(int)
    str2D = defaultdict(int)
    str1DL, str2DL = 0, 0
    len1, len2 = len(str1), len(str2)
    for a in range(len1-1):
        s = str1[a:a+2]
        if s.isalpha():
            str1D[s.lower()] += 1
            str1DL += 1
    for b in range(len2-1):
        s = str2[b:b+2]
        if s.isalpha():
            str2D[s.lower()] += 1
            str2DL += 1
            
    ### 공집합 처리 
    # 둘다 공집합 
    if str1DL==0 and str2DL==0:
        return 65536
    # 하나라도 공집합이면 inter=0 이라서 결과도 0
    elif str1DL==0 or str2DL==0:
        return 0
            
    ### 교집합 계산
    inter = 0
    for key in str1D.keys():
        inter += min(str1D[key], str2D[key])

    # union = len(A집합) + len(B집합) - intersect
    return math.floor((inter/(str1DL + str2DL - inter))*65536)