package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[s][e] = cost;
        }

        // 다익스트라
        int[][] minCost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
            minCost[i][i] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // {거리, node}
            pq.add(new int[]{0, i});
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int cost = curr[0], node = curr[1];
                if (cost > minCost[i][node]) {
                    continue;
                }

                for (int k = 1; k <= n; k++) {
                    if (arr[node][k] != 0 && cost + arr[node][k] < minCost[i][k]) {
                        minCost[i][k] = cost + arr[node][k];
                        pq.add(new int[]{minCost[i][k], k});
                    }
                }
            }
        }

        // 가장 오래 걸리는 시간 출력
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, minCost[i][x] + minCost[x][i]);
        }
        System.out.println(ans);
    }
}
