# https://school.programmers.co.kr/learn/courses/30/lessons/42577

class Node():
    def __init__(self, key):
        self.key = key
        self.end = False
        self.child = {}
        
    def addChild(self, key):
        self.child[key] = Node(key)

class Trie():
    def __init__(self):
        self.head = Node(None)
        
    def insert(self, phone):
        curr = self.head
        length = len(phone)
        for i in range(length):
            if phone[i] not in curr.child:
                curr.addChild(phone[i])
            curr = curr.child[phone[i]]
            if i == length-1 :
                curr.end = True
            
    def search(self, phone):
        curr = self.head
        for p in phone[:-1]:
            curr = curr.child[p]
            if curr.end:
                return True
        return False
    
    def insertAndSearch(self, phone):
        curr = self.head
        length = len(phone)
        for i in range(length):
            # insert
            if phone[i] not in curr.child:
                curr.addChild(phone[i])
            curr = curr.child[phone[i]]
            
            # 마지막 단어는 end = True (접두사가 존재하지 않는 단어)
            if i == length-1:
                curr.end = True
            # search (이미 나는 접두사가 존재, 뒤의 단어들을 굳이 탐색할 필요 X)
            else:
                if curr.end:
                    return True
        return False
    
def solution(phone_book):
    trie = Trie()
    
    ### solution 1
    # trie = Trie()
    # for p in phone_book:
    #     trie.insert(p)
    # for p in phone_book:
    #     if trie.search(p):
    #         return False
    # return True
    
    # for문을 2번 돌아서 O(2nm)이라는 시간 복잡도 발생 
    #   -> 정렬을 하면 뒤에 오는 단어가 앞에 오는 단어의 접두사일 가능성을 완전히 제거 -> 따라서 insertAndSearch를 동시에 할 수 있음
    ### solution 2
    phone_book.sort()
    trie = Trie()
    
    for p in phone_book:
        if trie.insertAndSearch(p):
            return False
    return True

### solution 3
def solution3(phone_book):
    phone_book.sort()  # 전화번호부 정렬

    for i in range(len(phone_book) - 1):
        if phone_book[i+1].startswith(phone_book[i]): 
            return False
    return True
