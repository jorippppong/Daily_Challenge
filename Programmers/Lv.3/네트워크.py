# https://school.programmers.co.kr/learn/courses/30/lessons/43162

def solution(n, computers):
    # network 갯수를 증가하는 조건 : BFS의 경우 queue가 비어있을 때
    queue = []
    networks = 1
    visited = [False] * n
    queue.append(0)
    visited[0] = True

    def BFS():
        # 리스트 변수는 참조되는 메모리 주소가 변경되지 않기 때문에 'nonlocal' 키워드 없이도 내부 함수에서 수정이 가능
        nonlocal networks
        
        while queue:
            curr = queue.pop(0)
            for next in range(0, len(visited)):
                if computers[curr][next] == 1 and visited[next] == False:
                    queue.append(next)
                    visited[next] = True
        
        if not queue and False in visited:
            # net 증가, 방문안한 노드 찾아서 큐에 넣고 다시 시작
            networks += 1
            curr = visited.index(False)
            queue.append(curr)
            BFS()

    BFS()
    return networks