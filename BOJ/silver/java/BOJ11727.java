package boj.silver.java;

import java.util.Scanner;

public class BOJ11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
