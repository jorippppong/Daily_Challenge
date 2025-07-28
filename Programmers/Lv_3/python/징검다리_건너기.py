# https://school.programmers.co.kr/learn/courses/30/lessons/64062

def solution(stones, k):
    # 최소로 건널 수 있는 사람 : 1명
    # 최대로 건널 수 있는 사람 : max(stones)명
    # 1부터 시작해서 늘려가면 시간 초과 -> 이진 탐색 사용
    answer = 0
    left, right = 1, max(stones)
    while left <= right:
        mid = (left+right)//2
        count = 0
        # 0 이하가 연속으로 몇개 있는지 count (mid명이 건넘)
        for stone in stones:
            if (stone-mid)<=0:
                count += 1
                # 건너기 불가능
                if count == k:
                    break
            else:
                count = 0
        if count < k:
            left = mid +1  # 인원 늘려도 괜찮
        else:
            # answer = mid  # 여기서 효율성 12번 실패
            right = mid -1  # 인원 줄여야 함
    return left  # ...???