package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        while (r-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[a][b] = cost;
            arr[b][a] = cost;
        }

        // 벨만 - 포드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((arr[i][k] != Integer.MAX_VALUE) && (arr[k][j] != Integer.MAX_VALUE)) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        // 아이템 최대 갯수 계산
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m) {
                    sum += items[j];
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
