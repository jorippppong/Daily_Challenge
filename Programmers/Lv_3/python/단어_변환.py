# https://school.programmers.co.kr/learn/courses/30/lessons/43163

from collections import deque

def canConvert(begin, target):
    diff = 0
    for i in range(len(begin)):
        if(begin[i] != target[i]):
            diff += 1
    if(diff == 1):
        return True
    return False

def solution(begin, target, words):
    queue = deque()
    queue.append((begin, 0))
    visited = [False] * (len(words))
    def BFS():
        nonlocal target
        while queue:
            word, depth = queue.popleft()
            for i in range(len(words)):
                if (not visited[i] and canConvert(word, words[i])):
                    if words[i] == target:
                        return depth+1
                    queue.append((words[i], depth+1))
                    visited[i] = True
    if target not in words:
        return 0
    return BFS()