# https://school.programmers.co.kr/learn/courses/30/lessons/43238

# 기준 : 모든 사람이 심사를 받는데 걸리는 시간
def solution(n, times):
    answer = 0
    times.sort()
    start, end = 1, max(times)*(n-len(times)+1)
    while start <= end:
        mid = (start + end)//2
        people = 0
        # 모든 사람이 mid분 이내에 심사를 받을 수 있는지 판별하는 코드
        # people : mid 시간 동안 심사를 받을 수 있는 최대 인원
        for time in times:
            people += mid//time
        # 최대 인원이 n보다 크거나 같으면 mid 줄이자! (더 적은 시간으로 n명 심사 가능)
        if people >= n:
            answer = mid
            end = mid - 1
        # 최대 인원이 n보다 작으면 mid를 늘리자! (더 많은 시간이 필요)
        else:
            start = mid + 1
    return answer