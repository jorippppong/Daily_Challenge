package programmers.Lv_2.java;

import java.util.PriorityQueue;

public class PRO42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        int ans = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int sum = pq.poll() + pq.poll() * 2;
            pq.add(sum);
            ans++;
        }

        return pq.peek() < K ? -1 : ans;
    }
}
