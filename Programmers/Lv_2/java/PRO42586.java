package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PRO42586 {
    public List solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.addLast(days);
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int days = queue.removeFirst();
            int cnt = 1;
            while (!queue.isEmpty() && queue.getFirst() <= days) {
                queue.removeFirst();
                cnt++;
            }
            answer.add(cnt);
        }

        return answer;
    }
}
