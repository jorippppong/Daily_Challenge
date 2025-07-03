package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int customers = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[customers + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= customer; i++) {
                dp[i] = Math.min(dp[i], cost);
            }
            for (int i = customer; i < customers + 101; i++) {
                dp[i] = Math.min(dp[i], dp[i - customer] + cost);
            }
        }
        System.out.println(dp[customers]);
    }
}
