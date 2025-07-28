# https://school.programmers.co.kr/learn/courses/30/lessons/49994

def solution(dirs):
    dirD = {"U":0, "D":1, "R":2, "L":3}
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    visited = []
    currX, currY = 0, 0
    answer = 0
    def canGo(x, y):
        return -5<=x<=5 and -5<=y<=5  
    
    for d in dirs:
        nextX, nextY = currX + dx[dirD[d]], currY + dy[dirD[d]]
        if not canGo(nextX, nextY):
            continue
        if (min(currX, nextX)+5, max(currX, nextX)+5, min(currY, nextY)+5, max(currY, nextY)) not in visited:
            answer += 1
            visited.append((min(currX, nextX)+5, max(currX, nextX)+5, min(currY, nextY)+5, max(currY, nextY)))
        currX, currY = nextX, nextY
    
    return answer