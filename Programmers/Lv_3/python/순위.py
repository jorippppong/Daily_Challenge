# https://school.programmers.co.kr/learn/courses/30/lessons/49191

import collections

def solution(n, results):
    # win ->  나 : {내가 이긴 사람}
    # lose ->  나 : {나를 이긴 사람}
    win = collections.defaultdict(set)
    lose = collections.defaultdict(set)
    for w, l in results:
        win[w].add(l)
        lose[l].add(w)  
        
    for i in range(1, n+1):
        # 나를 이긴 사람은 나의 승리를 모두 가져간다. 
        for winner in lose[i]:
            win[winner].update(win[i]) 
        # 나에게 진 사람은 나의 패배를 모두 가져간다.
        for loser in win[i]:
            lose[loser].update(lose[i])
            
    # 승리 + 패배 = 전체 - 1
    answer = 0
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n - 1 :
            answer += 1
    return answer