package boj.silver.java;

import java.util.Scanner;

public class BOJ17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int minCnt = Integer.MAX_VALUE;
            for(int j=1; j<=Math.sqrt(i); j++){
                minCnt = Math.min(dp[i - j*j], minCnt);
            }
            dp[i] = minCnt + 1;
        }

        System.out.println(dp[n]);
    }
}
