# https://school.programmers.co.kr/learn/courses/30/lessons/12929

def solution(n):
    answer = 0
    def make(used, left):
        nonlocal answer, n
        if used == n:
            answer+=1
            return
        # '('가 남아있을 때 -> 새로 '('를 넣거나, 뻬거나 둘다 가능
        # '('가 없을 때 -> 새로 '('를 넣는 것만 가능
        if left:
            make(used, left-1)
        make(used+1, left+1)
    make(1, 1) #사용한 괄호, stack에 남아있는 괄호
    return answer