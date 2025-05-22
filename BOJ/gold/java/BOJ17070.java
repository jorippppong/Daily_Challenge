package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n + 1][n + 1][3];
        dp[1][2][HORIZONTAL] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 1) {
                    dp[i][j][HORIZONTAL] += dp[i][j - 1][HORIZONTAL] + dp[i][j - 1][DIAGONAL];
                    dp[i][j][VERTICAL] += dp[i - 1][j][VERTICAL] + dp[i - 1][j][DIAGONAL];
                }
                if (arr[i][j] != 1 && arr[i - 1][j] != 1 && arr[i][j - 1] != 1) {
                    dp[i][j][DIAGONAL] += dp[i - 1][j - 1][HORIZONTAL] + dp[i - 1][j - 1][VERTICAL] + dp[i - 1][j - 1][DIAGONAL];
                }
            }
        }

        System.out.println(dp[n][n][HORIZONTAL] + dp[n][n][VERTICAL] + dp[n][n][DIAGONAL]);
    }

}
