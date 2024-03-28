# https://www.acmicpc.net/problem/14888

import math 

# count : 숫자의 갯수
def choose(count):
    global n, nums, oper, operOrder, answer
    if count == n:
        answer.append(calculate())
        return 
    for i in range(4):
        if oper[i] > 0:
            operOrder.append(i)
            oper[i] -= 1
            choose(count+1)
            popOper = operOrder.pop()
            oper[popOper] += 1
        
def calculate():
    global n, nums, oper, operOrder, answer
    result = nums[0]
    for idx in range(1, n):
        # 덧셈
        if operOrder[idx-1] == 0:
            result += nums[idx]
        # 뺄셈
        elif operOrder[idx-1] == 1:
            result -= nums[idx]
        # 곱셈
        elif operOrder[idx-1] == 2:
            result *= nums[idx]
        # 나눗셈
        elif operOrder[idx-1] == 3:
            # 양수 나누기 양수, 음수 나누기 음수 : 내림
            # 음수 나우기 양수 : 나누기 후 올림
            #if result == 0: result = 0
            if result < 0 and nums[idx] > 0 or result>0 and nums[idx]<0 :
                result = math.ceil(result/nums[idx])
            else:
                result = math.floor(result/nums[idx])
    return result

def solution():
    global n, nums, oper, operOrder, answer
    n = int(input())
    nums = list(map(int, input().split()))
    oper = list(map(int, input().split()))

    choose(1)
    print(max(answer))
    print(min(answer))

n = 0
nums = []
oper = []
operOrder = []
answer = []

solution()