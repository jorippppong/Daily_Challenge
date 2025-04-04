package leetcode.medium;

import java.util.HashMap;

/*
1. 아이디어 : 
트라이(trie) 또는 접두사 트리는 문자열 데이터 세트에서 키를 효율적으로 저장하고 검색하는 데 사용되는 트리 데이터 구조이다. 
자동 완성 및 철자 검사기와 같은 다양한 응용 프로그램에 트라이 알고리즘을 활용할 수 있다.

2. 시간복잡도 : 
(L : 문자열의 길이)
insert : O(L)
search, startsWith : O(L)
delete : O(L)

3. 자료구조/알고리즘 : 
Trie 알고리즘, HashMap 사용해서 child 알파벳들을 저장 & 탐색한다.
*/

public class LC208 {

    class Trie {
        Node head;

        public Trie() {
            this.head = new Node(null);
        }
        
        public void insert(String word) {
            Node curr = this.head;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.childs.containsKey(c)){
                    curr = curr.childs.get(c);
                }
                else{
                    Node newNode = new Node(c);
                    curr.childs.put(c, newNode);
                    curr = newNode;
                }

                if(i == word.length() -1){
                    curr.isEnd = true;
                }
            }
        }
        
        public boolean search(String word) {
            Node lastNode = findLastNode(word);
            if(lastNode == null || lastNode.isEnd == false) return false;
            return true;
        }
        
        public boolean startsWith(String prefix) {
            if(findLastNode(prefix) == null) return false;
            return true;
        }

        // 존재 안하면 null 반환
        public Node findLastNode(String word){
            Node curr = this.head;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.childs.containsKey(c)){
                    curr = curr.childs.get(c);
                }
                else{
                    return null;
                }
            }
            return curr;
        }

        class Node{
            Character key;
            HashMap<Character, Node> childs;
            boolean isEnd;

            public Node(Character key){
                this.key = key;
                this.childs = new HashMap<>();
                this.isEnd = false;
            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}