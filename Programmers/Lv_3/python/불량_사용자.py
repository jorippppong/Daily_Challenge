# https://school.programmers.co.kr/learn/courses/30/lessons/64064

def solution(user_id, banned_id):
    def dfs(idx):
        # 정답 추가하는 로직
        if idx == len(banned_id):
            tmp_list = []
            for i in range(len(visited)):
                if visited[i] == True:
                    tmp_list.append(user_id[i])

            answer.add(tuple(tmp_list))
            return
        
        for i in range(len(user_id)):
            if not visited[i] and check(user_id[i], banned_id[idx]):
                visited[i] = True
                dfs(idx+1)
                visited[i] = False
    
    answer = set()
    visited = [False] * len(user_id)
    
    dfs(0)
    return len(answer)

# 밴 당할 수 있는 이름인지 확인하는 함수
def check(u, b):
    if len(u) != len(b):
        return False
    for i in range(len(u)):
        if b[i] == '*':
            continue
        if u[i] != b[i]:
            return False
    return True