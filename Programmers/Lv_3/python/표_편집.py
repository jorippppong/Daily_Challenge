# https://school.programmers.co.kr/learn/courses/30/lessons/81303

def solution(n, k, cmd):
    curr= k
    up = [i-1 for i in range(n)] 
    down = [i+1 for i in range(n)]
    lst = ["O"] * n
    deletes = []
    
    for c in cmd:
        if c[0] == "U":
            for i in range(int(c[2:])):
                curr = up[curr]
        elif c[0] == "D":
            for i in range(int(c[2:])):
                curr = down[curr]
        elif c[0] == "C":
            lst[curr] = "X"
            deletes.append(curr)
            if down[curr] == n:
                curr = up[curr]
                down[curr] = n
            elif up[curr] == -1:
                curr = down[curr]
                up[curr] = -1
            else:
                upN = up[curr]
                downN = down[curr]
                down[upN] = downN
                up[downN] = upN
                curr = downN    
        elif c[0] == "Z":
            lastDelete = deletes.pop()
            lst[lastDelete] = "O"
            if up[lastDelete] == -1: 
                up[down[lastDelete]] = lastDelete
            elif down[lastDelete] == n:
                down[up[lastDelete]] = lastDelete
            else : 
                down[up[lastDelete]] = lastDelete
                up[down[lastDelete]] = lastDelete
            
    return "".join(lst)