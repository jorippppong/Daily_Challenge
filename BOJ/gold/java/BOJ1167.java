package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167 {
    private static List<int[]>[] arr;
    private static long diameter = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        arr = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            while (node != -1) {
                arr[idx].add(new int[]{node, Integer.parseInt(st.nextToken())});
                node = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, -1);
        System.out.println(diameter);
    }

    // DFS : node의 최대 가중치 길이를 return
    private static long dfs(int node, int prevNode) {
        List<Long> cost = new ArrayList<>();
        for (int[] next : arr[node]) {
            if (next[0] == prevNode) {
                continue;
            }
            cost.add(dfs(next[0], node) + next[1]);
        }
        cost.sort(Collections.reverseOrder());

        if (cost.isEmpty()) {
            return 0;
        }
        if (cost.size() == 1) {
            diameter = Math.max(diameter, cost.get(0));
        } else {
            diameter = Math.max(diameter, cost.get(0) + cost.get(1));
        }
        return cost.get(0);
    }
}
