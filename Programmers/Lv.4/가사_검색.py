import collections

class Node:
    def __init__(self, key):
        self.key = key
        self.child = {}
        self.length = []
        
class Trie:
    def __init__(self):
        self.head = Node(None)
    def insert(self, word):
        curr = self.head
        for w in word:
            if w not in curr.child:
                curr.child[w] = Node(w)
            curr.length.append(len(word))
            curr = curr.child[w]
        curr.length.append(len(word))
    def search(self, query):
        curr = self.head
        for q in query:
            if q == "?":
                return curr.length.count(len(query))
            elif q in curr.child:
                curr = curr.child[q]
            # 매칭 되는 단어가 없을 경우 
            else:
                return 0
                

def solution(words, queries):
    answer = []
    rev_words, count_words = [], collections.defaultdict(int)
    
    for word in words:
        rev_words.append(word[::-1])  # 2번 조건
        count_words[len(word)] += 1  # 3번 조건 
    
    trie = Trie()
    rev_trie = Trie()
    
    # insert
    for word in words:
        trie.insert(word)
    for word in rev_words:
        rev_trie.insert(word)
        
    # 3가지 조건에 맞게 search
    for query in queries:
        # 3번 조건
        if query[0] == "?" and query[-1] == "?":
            answer.append(count_words[len(query)])
        # 1번 조건
        elif query[-1] == "?":
            answer.append(trie.search(query))
        # 2번 조건
        elif query[0] == "?":
            answer.append(rev_trie.search(query[::-1]))
    return answer

# https://dev-note-97.tistory.com/171