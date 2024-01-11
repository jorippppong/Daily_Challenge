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