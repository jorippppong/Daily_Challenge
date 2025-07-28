# https://school.programmers.co.kr/learn/courses/30/lessons/42894

def solution(board):
    global length
    length = len(board)
    answer = 0
    
    # 검정 블록이 일직선으로 떨어질 수 있는지
    def canGo(x, y):
        for i in range(x+1):
            if board[i][y]:
                return False
        return True

    # 블록 삭제
    def remove(x1, y1, x2, y2, x3, y3, x4, y4):
        board[x1][y1] = 0
        board[x2][y2] = 0
        board[x3][y3] = 0
        board[x4][y4] = 0

    # 삭제 가능한 모양의 블록인지 확인
    def is1c(x, y):
        num = board[x][y]
        return x+1 < length and y+2 < length and board[x+1][y] == board[x+1][y+1] == board[x+1][y+2] == num

    def is1d(x, y):
        num = board[x][y]
        return x+2 < length and 0 <= y-1 and board[x+1][y] == board[x+2][y] == board[x+2][y-1] == num

    def is2b(x, y):
        num = board[x][y]
        return x+2 < length and y+1 < length and board[x+1][y] == board[x+2][y] == board[x+2][y+1] == num

    def is2c(x, y):
        num = board[x][y]
        return x+1<length and 0 <= y-2 and board[x+1][y-2] == board[x+1][y-1] == board[x+1][y] == num

    def is3a(x, y):
        num = board[x][y]
        return x+1 <length and 1 <= y <length-1 and board[x+1][y-1] == board[x+1][y] == board[x+1][y+1] == num
    
    # 블록 모양이 맞으면, 검정색으로 삭제 가능한지 확인 
    # 삭제 가능하면 0으로 바꾸고 처음부터 -ing
    # 삭제 불가능하면 다음칸으로 이동해서 진행.
    idx = 0
    while idx < length**2:
        x, y = idx//length, idx%length
        if board[x][y] == 0:
            idx += 1
        elif is1c(x,y) and canGo(x, y+1) and canGo(x, y+2):
            remove(x, y, x+1, y, x+1, y+1, x+1, y+2)
            idx = 0
            answer += 1             
        elif is1d(x,y) and canGo(x, y-1) and canGo(x+1, y-1):
            remove(x, y, x+1, y, x+2, y, x+2, y-1)
            idx = 0
            answer += 1           
        elif is2b(x,y) and canGo(x, y+1) and canGo(x+1, y+1):
            remove(x, y, x+1, y, x+2, y, x+2, y+1)
            idx = 0
            answer += 1            
        elif is2c(x,y) and canGo(x, y-1) and canGo(x, y-2):
            remove(x, y, x+1, y-2, x+1, y-1, x+1, y)
            idx = 0
            answer += 1            
        elif is3a(x,y) and canGo(x, y-1) and canGo(x, y+1):
            remove(x, y, x+1, y-1, x+1, y, x+1, y+1)
            idx = 0
            answer += 1
        else:
            idx += 1

    return answer