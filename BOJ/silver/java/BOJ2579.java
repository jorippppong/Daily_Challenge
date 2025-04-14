package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[301];
        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];
        dp[1] = stair[1];
        dp[2] = stair[2] + stair[1];
        dp[3] = Math.max(stair[3] + stair[1], stair[3] + stair[2]);
        for(int i=4; i<=n; i++){
            dp[i] = Math.max(dp[i-2], stair[i-1] + dp[i-3]) + stair[i];
        }
        System.out.println(dp[n]);
    }
}
