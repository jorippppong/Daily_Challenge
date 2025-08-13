package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class PRO42587 {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            q.addLast(new int[]{priorities[i], i});  // {우선순위, idx}
            pq.add(priorities[i]);
        }

        int answer = 1;
        while (!q.isEmpty()) {
            if (q.getFirst()[0] == pq.peek()) {
                int[] remove = q.remove();
                pq.poll();
                if (remove[1] == location) {
                    return answer;
                } else {
                    answer++;
                }
            } else {
                int[] remove = q.remove();
                q.addLast(remove);
            }
        }

        return -1;
    }
}
