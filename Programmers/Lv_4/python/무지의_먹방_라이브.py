# https://school.programmers.co.kr/learn/courses/30/lessons/42891

# https://dmaolon00.tistory.com/entry/ProgrammersPython-%EB%AC%B4%EC%A7%80%EC%9D%98-%EB%A8%B9%EB%B0%A9-%EB%9D%BC%EC%9D%B4%EB%B8%8C-%EA%B7%B8%EB%A6%AC%EB%94%94-%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90-%EC%B5%9C%EC%86%8C-%ED%9E%99
import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
 
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i + 1))
 
    prev = 0
    length = len(food_times)
 
    while (q[0][0] - prev) * length < k:
        k -= (q[0][0] - prev) * length
        length -= 1
        prev, _ = heapq.heappop(q)
 
    result = sorted(q, key=lambda x: x[1])
    return result[k % length][1]

# two pointer 연습해보기 (이거는 틀린 코드)
'''def solution(food_times, k):
    end = len(food_times) - 1
    location = {}
    for i in range(end):
        location[i] = i+1
    location[end] = 0
    prev, curr = end, location[end]
    for i in range(k):
        if(prev == curr and food_times[i] == 0):
            return -1
        if food_times[curr] != 0:
            food_times[curr] -= 1
        if(food_times[curr]) == 0:
            location[prev] = location[curr]
        else:
            prev = curr
        curr = location[prev]
    return location[curr] + 1'''