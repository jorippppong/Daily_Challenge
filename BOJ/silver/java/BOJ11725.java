package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // bfs
        Queue<Integer> q = new LinkedList<>();
        parent[1] = 1;
        visited[1] = true;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int num : arr[curr]) {
                if (!visited[num]) {
                    parent[num] = curr;
                    visited[num] = true;
                    q.add(num);
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i])
                    .append("\n");
        }
        System.out.println(sb);
    }

}
