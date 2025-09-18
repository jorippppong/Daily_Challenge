package programmers.Lv_3.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO42861 {
    private int[] parent;

    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.addAll(Arrays.asList(costs));

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (find(c[0]) != find(c[1])) {
                union(c[0], c[1]);
                answer += c[2];
            }
        }
        return answer;
    }

    private int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parent[Math.max(parentA, parentB)] = Math.min(parentA, parentB);
        }
    }
}
