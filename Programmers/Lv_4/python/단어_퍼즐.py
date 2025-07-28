# https://school.programmers.co.kr/learn/courses/30/lessons/12983

import math
def solution(strs, t):
    default = math.inf
    dp = [default for i in range(len(t)+1)]
    dp[0] = 0
    for i in range(1,len(t)+1):
        j = i - 5 if i > 5 else 0
        while j < i:
            if dp[j] + 1 < dp[i] and t[j:i] in strs:
                dp[i] = dp[j]+1
            j += 1

    return dp[len(t)] if dp[len(t)] != default else -1