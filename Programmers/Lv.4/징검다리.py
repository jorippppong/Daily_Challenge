# https://school.programmers.co.kr/learn/courses/30/lessons/43236

# 최단 거리 : 1 ~ distance 까지 가능 (이진 탐색 범위)
# 최단 거리가 성립할때를 만족하려면 바위를 몇개 제거해야하는 지를 기준으로 이진탐색
# Mid보다 짧으면 바위 제거, mid 보다 길거나 같으면 length=0으로 reset(바위 제거 X)
# 제거한 바위 갯수 > n : 최단 거리가 길다는 의미 -> 최단 거리 반으로 줄임
# 제거한 바위 갯수 <= n : 최단 거리만들 수 있음 -> 정답 & 최단 거리 늘림

def solution(distance, rocks, n):
    rocks.append(distance)  # 맨 마지막 돌의 위치도 추가 (for문 계산에 포함 필요)
    rocks.sort()
    answer = 0
    left, right = 1, distance
    while left <= right:
        mid = (left+right)//2
        lastRock = 0
        removeRocks = 0
        for idx in rocks:
            if idx - lastRock < mid:
                removeRocks += 1
            else:
                lastRock = idx        
        if removeRocks <= n:
            answer = max(answer, mid)
            left = mid+1
        else:
            right = mid-1
    return answer

# 참고 : https://gom20.tistory.com/204