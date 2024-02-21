# https://school.programmers.co.kr/learn/courses/30/lessons/67258

import collections

def solution(gems):
    start, end  = len(gems)-1, len(gems)-1
    used = collections.defaultdict(bool)
    answer = []
    
    # 사용하지 않았으니 False로 초기화 (초기 설정)
    for i in gems:
        used[i] = False
    gemsNum = len(used)
    usedGems = 0
    
    # 결과 찾기 (two pointer)
    while end >= 0:
        if not used[gems[start]]:
            usedGems += 1
            used[gems[start]] = True
        # 결과 찾음
        if usedGems == gemsNum:
            answer.append([end-start, start, end])
            end -= 1
            start = end
            # 사용 초기화 
            usedGems = 0
            for i in gems:
                used[i] = False
        elif start == 0:
            end -= 1
            start = end
        else:
            start -= 1
            
    # (구간, 시작, 끝) : 구간 & 시작idx를 기준으로 정렬 (출력할때 index + 1 필요)
    answer.sort()
    return [answer[0][1]+1, answer[0][2]+1]