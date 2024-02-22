# https://school.programmers.co.kr/learn/courses/30/lessons/42861

"""
Kruskal 알고리즘
: cost를 기준으로 내림차순 오름차순 정렬, cost를 기준으로 경로 확정
cycle이 발생하지 않도록 유의할 것 (이미 있는지 확인)
https://chanhuiseok.github.io/posts/algo-33/
"""
def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x:x[2])
    link = set([costs[0][0]])  # 시작점

    # !!! while 문 없이 그냥 for문으로만 돌리게 되면 모든 섬을 연결할 수 없는 경우가 발생한다. 따라서 while문을 사용해서 이미 연결된 것들을 기준으로 차례대로 연결해줌
    while len(link) != n:
        for cost in costs:
            # 둘다 이미 존재 (해당 경로 사용 완료)
            if cost[0] in link and cost[1] in link:
                continue
            # 둘 중 하나가 연결 안되어 있을 때 (경로 생성)
            elif cost[0] in link or cost[1] in link:
                link.update([cost[0], cost[1]])
                answer += cost[2]
                break
    return answer