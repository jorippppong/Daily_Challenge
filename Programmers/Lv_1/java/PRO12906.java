package programmers.Lv_1.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO12906 {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty()) {
                stack.addLast(num);
            } else {
                if (!stack.getLast().equals(num)) {
                    stack.addLast(num);
                }
            }
        }
        int size = stack.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = stack.getFirst();
            stack.removeFirst();
        }
        return answer;
    }
}
