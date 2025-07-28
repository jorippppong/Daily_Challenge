# https://school.programmers.co.kr/learn/courses/30/lessons/42885

def solution(people, limit):   
    answer = 0
    start, end = 0, len(people)-1  # two pointer
    
    people.sort()
    while start <= end:
        if start == end:
            answer += 1
            break
        # sum > limit : answer++, end--
        # sum <= limit : answer++, start++, end--
        if people[start]+people[end] <= limit:
            start += 1
        end -= 1
        answer += 1
    return answer