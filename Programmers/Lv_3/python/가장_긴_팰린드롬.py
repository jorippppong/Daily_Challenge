# https://school.programmers.co.kr/learn/courses/30/lessons/12904#

def evenSubstring(s):
    answer = [0, ]
    idx, width = 1, 0
    length, subLen = len(s), 1
    # idx<length and idx + width < length and idx - width -1 >= 0
    while 0 <= idx < length:
        # 자기 앞 알파벳이 자신과 같은지 확인
        if subLen == 1:
            if s[idx] == s[idx-1]:
                subLen += 1
                width += 1
            else:
                idx += 1      
        elif subLen > 1:
            if width + 1 <= idx < length - width:
                if s[idx-1-width] == s[idx+width]:
                    subLen += 2
                    width += 1
                else:
                    answer.append(subLen)
                    idx += 1
                    width, subLen = 0, 1
            else:
                answer.append(subLen)
                idx += 1
                width, subLen = 0, 1
    return max(answer)
    
def oddSubstring(s):
    answer = [1]
    idx, width = 1, 1
    length, subLen = len(s), 1
    # idx<length and idx + width < length and idx - width >= 0
    while width <= idx < length - width:
        if s[idx-width] == s[idx+width]:
            subLen += 2
            width += 1
            if idx - width < 0 or idx + width >= length:
                answer.append(subLen)
                idx += 1
                width, subLen = 1, 1
        else:
            answer.append(subLen)
            idx += 1
            width, subLen = 1, 1
    return max(answer)

def solution(s):
    return max(evenSubstring(s), oddSubstring(s))