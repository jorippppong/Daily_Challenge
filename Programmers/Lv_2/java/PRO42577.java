package programmers.Lv_2.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PRO42577 {
    // 1. HashMap
    public boolean solution_v1(String[] phone_book) {
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }

    // 2. Trie
    public boolean solution_v2(String[] phone_book) {
        Trie trie = new Trie();
        for (String phone : phone_book) {
            trie.insert(phone);
        }
        for (String phone : phone_book) {
            if (trie.hasPrefix(phone)) {
                return false;
            }
        }
        return true;
    }

    private static class Trie {
        Node head = new Node(-1, false);

        public void insert(String str) {
            Node curr = head;
            for (int i = 0; i < str.length(); i++) {
                int num = Character.getNumericValue(str.charAt(i));
                if (!curr.child.containsKey(num)) {
                    boolean isEnd = i == str.length() - 1;
                    curr.child.put(num, new Node(num, isEnd));
                }
                curr = curr.child.get(num);
                if (i == str.length() - 1) {
                    curr.isEnd = true;
                }
            }
        }

        public boolean hasPrefix(String str) {
            Node curr = head;
            for (int i = 0; i < str.length() - 1; i++) {
                int num = Character.getNumericValue(str.charAt(i));
                Node node = curr.child.get(num);
                if (node.isEnd) {
                    return true;
                }
                curr = node;
            }
            return false;
        }
    }

    private static class Node {
        int num;
        boolean isEnd;
        HashMap<Integer, Node> child;

        public Node(int num, boolean isEnd) {
            this.num = num;
            this.isEnd = isEnd;
            this.child = new HashMap<>();
        }
    }

}
