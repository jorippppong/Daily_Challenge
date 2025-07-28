# https://school.programmers.co.kr/learn/courses/30/lessons/17685

class Node(object):
    def __init__(self, key, cnt=0):
        self.key = key
        self.cnt = cnt
        self.child = {}

class Trie():
    def __init__(self):
        self.head = Node(None)
    def insert(self, word):
        curr = self.head
        for key in word:
            if key not in curr.child:
                curr.child[key] = Node(key)
            curr = curr.child[key]
            curr.cnt += 1
    def search(self, word):
        curr = self.head
        cnt = 0
        for key in word:
            cnt += 1
            curr = curr.child[key]
            if curr.cnt == 1:
                return cnt
        return cnt

def solution(words):
    answer = 0
    trie = Trie()
    for word in words:
        trie.insert(word)
    for word in words:
        answer += trie.search(word)
    return answer