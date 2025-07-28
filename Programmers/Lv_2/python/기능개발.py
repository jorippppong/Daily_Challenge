# https://school.programmers.co.kr/learn/courses/30/lessons/42586

import math

def solution(progresses, speeds):
    release = []
    for p, s in zip(progresses, speeds):
        release.append(math.ceil((100-p)/s))
    answer = []
    date, count = release[0], 1
    for idx in range(1, len(release)):
        if release[idx] <= date:
            count += 1
        else:
            answer.append(count)
            date, count = release[idx], 1
    answer.append(count)
    return answer