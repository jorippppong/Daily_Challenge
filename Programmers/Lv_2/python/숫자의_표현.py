# https://school.programmers.co.kr/learn/courses/30/lessons/12924

def solution(n):
    answer = 1
    calculate = [3, 2]  # 3 + 2n (연속한 2개의 합)
    while (n-calculate[0]) >= 0: # -4 % 2 == 0 같은 대참사를 막기 위해
        if (n-calculate[0])%calculate[1] == 0:
            answer += 1
        calculate[1] += 1
        calculate[0] += calculate[1]
    return answer

'''
1개 (1 + 1n)
2개 (3 + 2n)
1+2=3
2+3=5
3+4=7
4+5=9

3개 (6 + 3n)
1+2+3=6
2+3+4=9
3+4+5=12

4개 (10 + 4n)
'''