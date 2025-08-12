package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO12909 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.getLast() == '(') {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
