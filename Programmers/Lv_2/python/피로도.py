# https://school.programmers.co.kr/learn/courses/30/lessons/87946

def solution(k, dungeons):
    length, answer = len(dungeons), 0
    dLst, visited = [], [False]*length
    
    def maxDungeon():
        ph, cnt = k, 0
        for d in dLst:
            if ph >= dungeons[d][0] and ph - dungeons[d][1] >= 0:
                ph -= dungeons[d][1]
                cnt += 1
            else:
                return cnt
        return cnt
    
    def choose(num):
        nonlocal answer
        if num == length+1:
            answer = max(answer, maxDungeon())
            return
        
        for i in range(length):
            if visited[i]:
                continue
            
            dLst.append(i)
            visited[i] = True
            choose(num+1)
            p = dLst.pop()
            visited[p] = False
    
    choose(1)
    return answer