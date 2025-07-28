# https://school.programmers.co.kr/learn/courses/30/lessons/12981

def solution(n, words):
    alphabet = words[0][-1]
    wordSet = set([words[0]])
    for i in range(1, len(words)):
        if alphabet != words[i][0] or words[i] in wordSet:
            return [i%n + 1, i//n + 1]
        else:
            alphabet = words[i][-1]
            wordSet.add(words[i])
    return [0, 0]