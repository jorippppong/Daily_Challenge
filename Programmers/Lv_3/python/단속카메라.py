# https://school.programmers.co.kr/learn/courses/30/lessons/42884

def solution(routes):
    routes.sort(key = lambda x:x[1])
    answer = 1
    end = routes[0][1]
    for route in routes:
        start = route[0]
        if start > end:
            answer += 1
            end = route[1]
    return answer