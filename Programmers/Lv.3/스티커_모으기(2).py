# https://school.programmers.co.kr/learn/courses/30/lessons/12971

def solution(sticker):
    # 스티커가 하나
    if len(sticker)==1 : return sticker[0]
    # 스티커가 두개
    elif len(sticker) == 2 : return max(sticker)
    # 첫번째 스티커를 선택(마지막 스티커 선택 불가능), 첫번째 스티커를 선택X(마지막 스티커 선택 가능)
    return max(maxSticker(sticker[:-1]), maxSticker(sticker[1:]))
    
# 입력의 크기가 2 이상일 때부터 유효(따라서 문제에서 주어진 스티커의 크기가 3이상 이여야 한다.)
def maxSticker(sticker):
    dp = [0] * (len(sticker))
    dp[0] = sticker[0]
    dp[1] = max(sticker[0], sticker[1]) # 더 큰 값 선택
    for i in range(2, len(dp)):
        dp[i] = max(dp[i-2]+sticker[i], dp[i-1])
    return dp[-1]