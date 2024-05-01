# https://school.programmers.co.kr/learn/courses/30/lessons/17680

def solution(cacheSize, cities):
    cache = {}
    answer = 0
    if cacheSize == 0:
        return 5*len(cities)
            
    for i in range(len(cities)):
        city = cities[i].lower()
        # hit
        if city in cache:
            cache[city] = i
            answer += 1
        # miss
        else:
            if len(cache) == cacheSize:
                deleteC = sorted(cache.items(), key = lambda x:x[1])[0][0]  
                del cache[deleteC]
            cache[city] = i
            answer += 5
    return answer