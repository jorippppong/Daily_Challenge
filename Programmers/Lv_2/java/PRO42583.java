package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();

        int totalWeight = 0;
        int idx = 0;
        int time = 0;
        while (true) {
            if (idx == truck_weights.length) {
                return time + bridge_length;
            }
            if (q.size() < bridge_length) {
                if (truck_weights[idx] + totalWeight <= weight) {
                    q.addLast(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else {
                    q.addLast(0);
                }
                time++;
            }
            if (q.size() == bridge_length) {
                int removeWeight = q.removeFirst();
                totalWeight -= removeWeight;
            }
        }
    }
}
