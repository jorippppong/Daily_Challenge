# https://school.programmers.co.kr/learn/courses/30/lessons/12949

def solution(arr1, arr2):
    answer = []
    arr1Row, arr1Col = len(arr1), len(arr1[0])
    arr2Col = len(arr2[0])
    for i in range(arr1Row):
        lst = []
        for j in range(arr2Col):
            num = 0
            for k in range(arr1Col):
                num += arr1[i][k] * arr2[k][j]
            lst.append(num)
        answer.append(lst)
    return answer