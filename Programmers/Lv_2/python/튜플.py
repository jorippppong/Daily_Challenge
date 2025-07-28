# https://school.programmers.co.kr/learn/courses/30/lessons/64065

import collections

def solution(s):
    splitS = s.split("},{")
    splitS[0] = splitS[0][2:]
    splitS[-1] = splitS[-1][:-2]
    tup, answer = [], []
    for ss in splitS:
        sss = list(map(int, ss.split(',')))
        tup.append([len(sss), sss])
    tup.sort()
    
    numSet = set()
    for _, lst in tup:
        for i in lst:
            if i in numSet:
                continue
            answer.append(i)
            numSet.add(i)
    return answer   