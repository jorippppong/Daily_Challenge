# https://school.programmers.co.kr/learn/courses/30/lessons/12911

def solution(n):
    oneCount = format(n, 'b').count("1")
    num = n +1
    while True:
        if format(num, 'b').count("1") == oneCount:
            return num
        else:
            num += 1