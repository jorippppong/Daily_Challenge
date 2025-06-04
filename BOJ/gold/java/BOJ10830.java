package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = dnc(b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ans[i][j] % 1000)
                        .append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // divide and conquer
    private static int[][] dnc(long exp) {
        if (exp == 1) {
            return arr;
        }

        int[][] temp = dnc(exp / 2);
        int[][] ans = cal(temp, temp);
        if (exp % 2 == 0) {
            return ans;
        }
        return cal(ans, arr);
    }

    private static int[][] cal(int[][] a, int[][] b) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += (a[i][k] * b[k][j]);
                }
                ans[i][j] = sum % 1000;
            }
        }
        return ans;
    }
}
