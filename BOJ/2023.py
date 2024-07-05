# https://www.acmicpc.net/problem/2023

import math

n = int(input())
answer, word = [], []

def BT(loc):
    global n
    if loc == n:
        answer.append("".join(word))
    for i in range(10):
        if can(i):
            word.append(str(i))
            BT(loc+1)
            word.pop()
    return None

# word + i 가 소수인지 확인
def can(i):
    num = int("".join(word) + str(i))
    if num < 2: return False
    for i in range(2, int(math.sqrt(num))+1):
        if num%i == 0: return False
    return True

BT(0)
answer.sort()
for a in answer:
    print(a)