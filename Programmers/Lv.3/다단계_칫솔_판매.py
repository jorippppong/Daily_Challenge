# https://school.programmers.co.kr/learn/courses/30/lessons/77486

import collections

def solution(enroll, referral, seller, amount):
    # 초기 설정 {자식:부모}
    parent = {} 
    for e, r in zip(enroll, referral):
        parent[e] = r
    
    # 돈 계산
    money = collections.defaultdict(int)
    for i in range(len(seller)):
        e = seller[i] # e : enroll (등록인)
        r = parent[e] # r : referral (추천인)
        m = amount[i]*100
        while r != "-" and m > 0:
            if m >= 10:
                give = m//10
                money[e] += (m - give)
                m = give
            else:
                money[e] += m
                m = 0
            e = r
            r = parent[e]
        if r == "-":
            if m >= 10:
                money[e] += (m - m//10)
            else:
                money[e] += m
    
    # 결과 출력
    answer = []
    for e in enroll:
        answer.append(money[e])
    return answer