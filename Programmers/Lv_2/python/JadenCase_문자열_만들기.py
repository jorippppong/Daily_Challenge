# https://school.programmers.co.kr/learn/courses/30/lessons/12951

def solution(s):
    answer = ''
    isBlank = True
    for i in s:
        if i == " ":
            isBlank = True
            answer += i
        elif i.isdigit():
            answer += i
            isBlank = False
        elif isBlank == True and i.islower():
            isBlank = False
            answer += i.upper()
        elif isBlank == True and i.isupper():
            isBlank = False
            answer += i
        elif isBlank == False:
            answer += i.lower()
    return answer