package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1967 {
    private static List<int[]>[] arr;
    private static int[] sumCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        sumCost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[parent].add(new int[]{child, cost});
        }

        dfs(1);
        int ans = Arrays.stream(sumCost).max().orElse(0);
        System.out.println(ans);
    }

    private static int dfs(int node) {
        if (arr[node].isEmpty()) {
            return 0;
        }
        List<Integer> roads = new ArrayList<>();
        for (int[] child : arr[node]) {
            int childNode = child[0];
            int cost = child[1];
            int road = cost + dfs(childNode);
            roads.add(road);
        }
        roads.sort(Collections.reverseOrder());
        sumCost[node] += roads.get(0);
        sumCost[node] += roads.size() >= 2 ? roads.get(1) : 0;
        return roads.get(0);
    }
}
