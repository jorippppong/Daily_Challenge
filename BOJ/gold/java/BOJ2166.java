package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i][0] * arr[i + 1][1];
            sum -= (long) arr[i + 1][0] * arr[i][1];
        }
        double ans = Math.abs(sum) * 0.5;
        System.out.printf("%.1f", ans);
    }
}
