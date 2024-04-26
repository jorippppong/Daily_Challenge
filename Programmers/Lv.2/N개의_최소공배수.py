# https://school.programmers.co.kr/learn/courses/30/lessons/12953

def solution(arr):
    result = 1
    for a in arr:
        result = lcm(result, a)
    return result

def lcm(x, y):
    return x*y//gcd(x,y)

def gcd(x,y):
    while y:
        x, y= y, x%y
    return x