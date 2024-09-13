# https://www.acmicpc.net/problem/3665

n = int(input())
while n:
    n -= 1
    ### 입력
    teamNum = int(input())
    preRank = list(map(int, input().split()))
    changedNum = int(input())
    changedTeam = []
    if changedNum:
        changedTeam = [list(map(int, input().split())) for _ in range(changedNum)]
    
    ### 순위 list
    # pre 순위 (win : 1, lose : -1, 자기자신 : 0)
    rank = [[0]*(teamNum+1) for _ in range(teamNum+1)]
    for w in range(teamNum):
        for l in range(w+1, teamNum):
            rank[preRank[w]][preRank[l]] = 1
            rank[preRank[l]][preRank[w]] = -1
    # 순위 갱신
    for w, l in changedTeam:
        rank[w][l] = -rank[w][l]
        rank[l][w] = -rank[l][w]

    ### 순위 일관성 확인
    flag = True
    for i in range(teamNum):
        for j in range(teamNum):
            for k in range(teamNum):
                if flag:
                    if i == j or i==k or j==k:
                        continue
                    if rank[i][j] == 1:
                        if rank[i][k] == -1 and rank[j][k] != -1:
                            print("IMPOSSIBLE")
                            flag = False
                            break                 
                    elif rank[j][i] == 1:
                        if rank[j][k] == -1 and rank[i][k] != -1:
                            print("IMPOSSIBLE")
                            flag = False
                            break
    
    realRank = [0]*teamNum
    if flag:
        ### 순위 결정 
        for i in range(1, teamNum+1):
            idx = teamNum - rank[i].count(1) - 1
            if realRank[idx] != 0:
                print("?")
                flag = False
                break
            else:
                realRank[idx] = i
    
    ### 결과 출력
    if flag:
        print(" ".join(str(r) for r in realRank))