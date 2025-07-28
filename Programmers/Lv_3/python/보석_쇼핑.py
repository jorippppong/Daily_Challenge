# https://school.programmers.co.kr/learn/courses/30/lessons/67258

"""
결과 찾기 (two pointer) 
: 보석의 종류가 모자르면 end을 증가, 보석의 종류가 충분하면 start을 증가
: 이때 증가하는 과정에서 dict(map)에 있는 보석의 숫자를 알맞게 증가&감소 해야한다. 
: 얻은 보석 수가 0이 될때는 0이라고 하지 말고, 아예 삭제하자! (계산의 편리함을 위해)
"""
import collections 

def solution(gems):
    n = len(gems)
    answer = []
    kind = len(set(gems)) # 보석 종류 갯수
    used = collections.defaultdict(int)  # 보석 사용 확인
    used[gems[0]] = 1
    start, end = 0, 0
    while start<n and end<n:
        # 보석의 종류가 부족 : end 증가 & used 갱신(증가)
        if len(used) < kind:
            end += 1
            # end가 맨 끝에 있었을 경우는 갱신 X (더 가면 index error)
            if end == n:
                break
            used[gems[end]] = used[gems[end]] + 1
        # 보석의 종류가 충분 : 답 갱신, start 증가 & used 갱신(감소)
        else:
            answer.append([end-start, start, end])
            if used[gems[start]] == 1:
                del used[gems[start]]
            else:
                used[gems[start]] -= 1
            start += 1           
            
    # (구간, 시작, 끝) : 구간 & 시작idx를 기준으로 정렬 (출력할때 index + 1 필요)
    answer.sort()  
    return [answer[0][1]+1, answer[0][2]+1]


'''
(런타임 에러)
def solution(gems):
    start, end  = len(gems)-1, len(gems)-1
    used = collections.defaultdict(bool)
    answer = []
    
    # 사용하지 않았으니 False로 초기화 (초기 설정)
    for i in gems:
        used[i] = False
    gemsNum = len(used)
    usedGems = 0
    
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
            for i, _ in used.items():
                used[i] = False
        elif start == 0:
            end -= 1
            start = end
        else:
            start -= 1
            
    # (구간, 시작, 끝) : 구간 & 시작idx를 기준으로 정렬 (출력할때 index + 1 필요)
    answer.sort()
    return [answer[0][1]+1, answer[0][2]+1]
'''