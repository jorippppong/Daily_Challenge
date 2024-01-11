# https://school.programmers.co.kr/learn/courses/30/lessons/42628

from heapq import heappush, heappop

def solution(arguments):
    max_heap = []
    min_heap = []
    for arg in arguments:
        if arg == "D 1":
            if max_heap != []:
                heappop(max_heap)
                if max_heap == [] or -max_heap[0] < min_heap[0]:
                    min_heap = []
                    max_heap = []
        elif arg == "D -1":
            if min_heap != []:
                heappop(min_heap)
                if min_heap == [] or -max_heap[0] < min_heap[0]:
                    max_heap = []
                    min_heap = []
        else:
            num = int(arg[2:])
            heappush(max_heap, -num)
            heappush(min_heap, num)
    if min_heap == []:
        return [0, 0]
    return [-heappop(max_heap), heappop(min_heap)]

# def solution(operations):
#     answer = []
#     heap = []
#     for i in operations:
#         x = i.split()
#         x[1] = int(x[1])
#         if x[0] == 'I':
#             heap.append(x[1])
#         if x[0] == 'D':
#             if heap:
#                 if x[1] == -1:
#                     heap.remove(min(heap))
#                 elif x[1] == 1:
#                     heap.remove(max(heap))
#     if not heap:
#         answer.extend([0, 0])
#     else:
#         answer.extend([max(heap), min(heap)])
#     return answer