# https://school.programmers.co.kr/learn/courses/30/lessons/92335

from collections import deque
import math

def convert(n, k):
    result = deque()
    while n > 0:
        result.appendleft(n%k)
        n //= k
    return result

def lstToDecimal(lst):
    result = 0
    lst = lst[::-1]
    for i, n in enumerate(lst):
        result += (10**i)*n
    return result  
        
def splitByZero(cLst, candidate):
    result = []
    for c in cLst:
        if c != 0:
            result.append(c)
        else:
            candidate.append(lstToDecimal(result))
            result = []
    candidate.append(lstToDecimal(result))
    
def isPN(num):
    if num == 1 or num == 0:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num%i == 0:
            return False
    return True

def solution(n, k):  
    cLst = convert(n, k)
    candidate = []
    splitByZero(cLst, candidate)
    answer = 0
    for c in candidate:
        if isPN(c):
            answer += 1
    return answer