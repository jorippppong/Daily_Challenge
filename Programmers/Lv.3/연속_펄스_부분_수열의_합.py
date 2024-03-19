# https://school.programmers.co.kr/learn/courses/30/lessons/161988

def solution(sequence):
    length = len(sequence)
    def maxSubsequence(arr):
        nonlocal length
        dp = [0] * length
        dp[0] = arr[0]
        # 다시 0으로 초기화 하거나, 이전의 값을 이어가거나 둘 중 하나 
        for i in range(1, length):
            dp[i] = max(0, dp[i-1]) + arr[i]
        return max(dp)
    
    arr1 = [0]*(length)
    arr2 = [0]*(length)
    for i in range(length):
        if i%2:
            arr1[i], arr2[i] = sequence[i], -sequence[i]
        else:
            arr1[i], arr2[i] = -sequence[i], sequence[i]
    return max(maxSubsequence(arr1), maxSubsequence(arr2))