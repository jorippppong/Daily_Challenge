# https://school.programmers.co.kr/learn/courses/30/lessons/49995

def solution(cookie):
    answer = 0
    # 기준점은 첫째 아들의 과자 마지막(= 둘째 아들의 과자 시작 -1) (양 사이드로 늘려감)
    # pointer : (첫째 아들의 마지막 과자 위치) 1 ~ len(cookie) - 1
    for pointer in range(len(cookie) - 1):
        firstF, secondL =  pointer, pointer + 1 # first first, second last
        firstC, secondC = cookie[firstF], cookie[secondL] # C: cookie
        while firstF > -1 and secondL < len(cookie):
            if firstC == secondC:
                answer = max(answer, firstC)
                firstF -= 1 
                secondL += 1
                if secondL < len(cookie) and firstF > -1:
                    firstC += cookie[firstF]
                    secondC += cookie[secondL]
            elif firstC > secondC:
                secondL += 1
                if secondL < len(cookie):
                    secondC += cookie[secondL]
            else:
                firstF -= 1
                if firstF > -1:
                    firstC += cookie[firstF]
    return answer