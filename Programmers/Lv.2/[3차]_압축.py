# https://school.programmers.co.kr/learn/courses/30/lessons/17684

def solution(msg):
    dictD = {}
    # 1. 초기화, 65 -> A
    for i in range(26):
        dictD[chr(i+65)] = i+1
    dictEnd = 26
    start, end = 0, 1
    answer = []
    length = len(msg)
    
    while start < length:
        if msg[start:end] in dictD:
            if end == length:
                answer.append(dictD[msg[start:end]])
                return answer
            else:
                end += 1
        else:
            answer.append(dictD[msg[start:end-1]]) # 3. 색인 출력
            # 4. w+c 등록
            dictEnd += 1
            dictD[msg[start:end]] = dictEnd
            # 3. 입력에서 w 제거
            start = end-1 