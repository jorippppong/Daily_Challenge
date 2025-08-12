package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();  // {값, idx}
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.getLast()[0] > prices[i]) {
                int[] remove = stack.removeLast();
                answer[remove[1]] = i - remove[1];
            }
            stack.addLast(new int[]{prices[i], i});
        }
        while (!stack.isEmpty()) {
            int[] remove = stack.removeLast();
            answer[remove[1]] = prices.length - remove[1] - 1;
        }
        return answer;
    }
}
