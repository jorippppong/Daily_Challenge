// https://www.acmicpc.net/problem/11660

package boj.silver.java;

import java.util.Scanner;

public class BOJ11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                dp[i][j] = sc.nextInt();
            }
        }

        // 누적합 구하기 (세로, 가로)        
        for(int j=1; j<n+1; j++){
            for(int i=2; i<n+1; i++){
                dp[i][j] += dp[i-1][j];
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=2; j<n+1; j++){
                dp[i][j] += dp[i][j-1];
            }
        }

        // 결과 구하기
        for(int i=0; i<m; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            System.out.println(result);
        }

        sc.close();
    }
}
