# https://school.programmers.co.kr/learn/courses/30/lessons/17687

def solution(n, t, m, p):
    length, num = 0, 0
    answer = ""
    change = {10: "A", 11:"B", 12:"C", 13:"D", 14:"E", 15:"F"}
    
    def convert(num):
        nonlocal length, n, answer
        result = ""
        if num == 0:
            result = "0"
        while num > 0:
            num, res = num//n , num%n
            if res >= 10:
                res = change[res]
            else:
                res = str(res)
            result += res
        answer += result[::-1]
        length += len(result)
        
    while length < m*t:
        convert(num)
        num += 1
    
    result = ""
    for i in range(t):
        result += answer[m*i + p -1]
    return result