# https://school.programmers.co.kr/learn/courses/30/lessons/84512

def solution(word):
    words, alpha = [], []
    lst = ["A", "E", "I", "O", "U"]
    
    def make(s):
        if 1 <= s <= 5:
            words.append("".join(alpha))
        if s == 5:
            return 
        for l in lst:
            alpha.append(l)
            make(s+1)
            alpha.pop()
        
    make(0)
    words.sort()
    return words.index(word) + 1