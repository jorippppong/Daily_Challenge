package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    private static final int MIN = 0;
    private static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());  // 수빈
        int k = Integer.parseInt(st.nextToken());  // 동생

        int[] depth = new int[MAX];
        Arrays.fill(depth, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        depth[n] = 0;

        int shortest = Integer.MAX_VALUE;
        int cnt = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == k) {
                if (shortest > depth[curr]) {
                    shortest = depth[curr];
                    cnt = 1;
                } else if (shortest == depth[curr]) {
                    cnt++;
                }
            }

            for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                if (next < MIN || next >= MAX) continue;

                // 처음 방문 or 같은 depth (중복 저장 허용)
                if (depth[next] == -1 || depth[next] == depth[curr] + 1) {
                    q.add(next);
                    depth[next] = depth[curr] + 1;
                }
            }
        }

        System.out.println(shortest);
        System.out.println(cnt);
    }
}
