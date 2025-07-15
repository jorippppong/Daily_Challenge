package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] forward = new List[n + 1];
        List<int[]>[] backward = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            forward[s].add(new int[]{e, c});
            backward[e].add(new int[]{s, c});
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 1. 다익스트라
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            if (cost > dp[node]) {
                continue;
            }
            for (int[] next : forward[node]) {
                if (cost + next[1] < dp[next[0]]) {
                    dp[next[0]] = cost + next[1];
                    pq.add(new int[]{dp[next[0]], next[0]});
                }
            }
        }

        // 2. 역추적
        List<Integer> ans = new ArrayList<>();
        int idx = end;
        ans.add(end);
        while (idx != start) {
            for (int[] next : backward[idx]) {
                if (dp[idx] - next[1] == dp[next[0]]) {
                    ans.add(next[0]);
                    idx = next[0];
                    break;
                }
            }
        }

        // 출력
        System.out.println(dp[end]);
        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i))
                    .append(" ");
        }
        System.out.println(sb);

    }
}
