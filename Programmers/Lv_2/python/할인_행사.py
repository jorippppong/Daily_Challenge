# https://school.programmers.co.kr/learn/courses/30/lessons/131127

from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    user = defaultdict(int)
    market = defaultdict(int)
    for w, n in zip(want, number):
        user[w] = n
        
    for j in range(len(discount)):
        # 10일 전꺼는 제외시킴
        prev = j - 10
        if prev > -1:
            market[discount[prev]] -= 1
        
        # 새로 추가
        market[discount[j]] += 1
        
        # 두개의 dictionary가 동일하면 answer++
        available = True
        for key in user.keys():
            if user[key] != market[key]:
                available = False
                break
        if available:
            answer += 1
        
    return answer