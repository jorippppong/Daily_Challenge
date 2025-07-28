# https://school.programmers.co.kr/learn/courses/30/lessons/64063

def solution(k, room_number):
    rooms = dict()
    
    def find_empty_room(number):
        path = [number]
        while number in rooms:
            number = rooms[number]
            path.append(number)
        for num in path:
            rooms[num] = number + 1
        return number

    answer = []
    for number in room_number:
        empty_room = find_empty_room(number)
        answer.append(empty_room)
        
    return answer

"""
rooms는 사용 가능한 다음 방의 번호를 저장하는 dict (ex. {1:3, 3:6, 4:5})
rooms를 사용해서 이미 사용된 방을 pass하고 더 큰 방을 탐색할 수 있게된다. 
왜냐하면 rooms의 Key 값이 이미 배정 완료된 방의 번호이기 때문이다. 
이미 배정 완료된 방의 다음 번호로 타고타고 넘어가기 때문에 상수 시간 내에 찾기 가능.
새로 방 할당 후에 {path에 있는 num들 : 새로 배정된 방 번호 +1}을 rooms에 추가한다. 
이를 통해 그 다음에 배정 가능한 방 번호가 계속 갱신된다. 
2,3번이 배정 완료 되었으면 1번을 희망할 경우 2번과 3번은 신경 ㄴㄴ and 4번이 할당 가능한 그런 매커니즘

[시간 복잡도] 
find_empty_room : Union-Find 알고리즘의 Path Compression 기법 덕분에 거의 상수 시간
따라서 O(n) 소요.
"""