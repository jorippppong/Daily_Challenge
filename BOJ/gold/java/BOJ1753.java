package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        List<int[]>[] arr = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[a].add(new int[]{b, cost});  // {node, cost}
        }

        // dijkstra
        int[] shortest = new int[v + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[startNode] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, startNode});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];
            if (cost > shortest[node]) {
                continue;
            }
            for (int[] edge : arr[node]) {
                if (cost + edge[1] < shortest[edge[0]]) {
                    shortest[edge[0]] = cost + edge[1];
                    pq.add(new int[]{shortest[edge[0]], edge[0]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(shortest[i] == Integer.MAX_VALUE ? "INF" : shortest[i])
                    .append("\n");
        }
        System.out.println(sb);
    }
}
