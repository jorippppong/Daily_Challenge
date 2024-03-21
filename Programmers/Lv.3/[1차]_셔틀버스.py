# https://school.programmers.co.kr/learn/courses/30/lessons/17678

def solution(n, t, m, timetable):
    # bustable, crewtable은 전부 분단위로 변환
    bustable = [9*60 + t*num for num in range(n)]
    crewtable = [int(t[:2])*60 + int(t[3:]) for t in timetable]
    crewtable.sort()
    
    answer = []
    crew = 0
    # 자리가 있으면 버스 도착 시간에 도착
    # 자리가 없으면 가장 늦게 온 사람보다 일분 일찍 도착하면됨
    for b in bustable:
        count = m
        while count > 0 and crew < len(crewtable):
            if crewtable[crew] <= b:
                count -= 1
                crew += 1
            else:
                break
        if count:
            answer.append(b)
        else:
            answer.append(crewtable[crew-1] -1)
    
    ans = max(answer)
    return str(ans//60).zfill(2) + ":" + str(ans%60).zfill(2)