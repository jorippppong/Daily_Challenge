# https://school.programmers.co.kr/learn/courses/30/lessons/43165

def solution(numbers, target):
    answer = 0
    length = len(numbers)
    sign = []
    
    def calculate(sign):
        nonlocal answer
        # 1 : 양수, 0 : 음수
        result = 0
        for s, n in zip(sign, numbers):
            if s == 1:
                result += n
            else:
                result -= n
        if result == target:
            answer += 1
            
    def choose(idx):
        if idx == length + 1:
            calculate(sign)
            return 
        for i in range(2):
            sign.append(i)
            choose(idx+1)
            sign.pop()
        
    choose(1)
    return answer