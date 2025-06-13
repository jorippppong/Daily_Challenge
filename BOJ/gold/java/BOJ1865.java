package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List<int[]> vertex = new ArrayList<>();
            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (i < m) {
                    vertex.add(new int[]{s, e, t});
                    vertex.add(new int[]{e, s, t});
                } else {
                    vertex.add(new int[]{s, e, -t});
                }
            }

            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                if (hasMinusCycle(vertex, i)) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }

    }

    private static boolean hasMinusCycle(List<int[]> vertex, int startNode) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode] = 0;
        // n
        for (int i = 1; i <= n; i++) {
            // v
            boolean isUpdated = false;
            for (int[] v : vertex) {
                int s = v[0];
                int e = v[1];
                int t = v[2];
                if (distance[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distance[e] > distance[s] + t) {
                    distance[e] = distance[s] + t;
                    isUpdated = true;
                    if (i == n) {
                        return true;
                    }
                }
            }
            if (!isUpdated) {
                break;
            }
        }
        return false;
    }
}
