package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static int[][] arr;
    private static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[a][b] = cost;
            arr[b][a] = cost;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int[] oneStart = dijkstra(1);
        int middle = dijkstra(u)[v];
        int[] nStart = dijkstra(node);

        int ans = Integer.MAX_VALUE;
        // 1 -> u -> v -> n
        if (oneStart[u] != MAX_NUM && middle != MAX_NUM && nStart[v] != MAX_NUM) {
            ans = Math.min(ans, oneStart[u] + middle + nStart[v]);
        }
        // 1 -> v -> u -> n
        if (oneStart[v] != MAX_NUM && middle != MAX_NUM && nStart[u] != MAX_NUM) {
            ans = Math.min(ans, oneStart[v] + middle + nStart[u]);
        }
        System.out.println(ans == MAX_NUM ? -1 : ans);
    }

    private static int[] dijkstra(int startNode) {
        int[] shortest = new int[node + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[startNode] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, startNode}); // {shortest, node}
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], dest = curr[1];
            if (cost > shortest[dest]) {
                continue;
            }

            for (int i = 1; i <= node; i++) {
                if (arr[dest][i] != 0 && cost + arr[dest][i] < shortest[i]) {
                    shortest[i] = cost + arr[dest][i];
                    pq.add(new int[]{shortest[i], i});
                }
            }
        }
        return shortest;
    }

}
