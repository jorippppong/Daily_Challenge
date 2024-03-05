# https://school.programmers.co.kr/learn/courses/30/lessons/131701

def solution(elements):
    numbers = set()
    length = len(elements)
    for i in range(length):
        number = elements[i]
        numbers.add(number)
        for j in range(i+1, i+length):
            number += elements[j%length]
            numbers.add(number)
    return len(numbers)