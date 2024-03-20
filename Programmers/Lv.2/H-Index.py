# https://school.programmers.co.kr/learn/courses/30/lessons/42747

import collections

def solution(citations):
    nums = collections.defaultdict(int)
    answer = [0]
    for c in citations:
        nums[c] += 1
    sorted_nums = sorted(nums.items(), key = lambda item:item[0], reverse = True)
    count = 0
    for k, v in sorted_nums:
        count += v
        if k and k >= count:
            answer.append(count)
    return max(answer)