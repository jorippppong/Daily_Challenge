# https://school.programmers.co.kr/learn/courses/30/lessons/42579

def solution(genres, plays):
    music = {}
    genreSum = {}
    answer = []
    # {"pop" : [(600, 1), (2500, 4)]}
    for i in range(len(plays)):
        if genres[i] not in music:
            music[genres[i]] = []
        music[genres[i]].append((plays[i], i))
        # {"pop" : 3100}
        if genres[i] not in genreSum:
            genreSum[genres[i]] = 0
        genreSum[genres[i]] += plays[i]
    # 합이 가장 높은 장르 순서대로 정렬
    sorted_gS = sorted(genreSum.items(), key=lambda x: -x[1])
    # 합이 높은 장르 순서대로 2개씩 저장 (! dict는 sorted하면 tuple로 묶은 리스트를 반환)
    for genre, _ in sorted_gS:
        # 같은 장르의 음악들 내림차순으로 정렬
        sorted_value = sorted(music[genre], key=lambda x: (-x[0], x[1]))
        answer.append(sorted_value[0][1])
        if(len(sorted_value) > 1):
            answer.append(sorted_value[1][1])

    return answer