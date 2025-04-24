package boj.silver.java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a][b] = 1;
            dp[b][a] = 1;
        }
        for(int i=1; i<=n; i++){
            dp[i][i] = 0;
        }

        // 플로이드 - 워셜
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int num = 0;
        for(int i=n; i>=1; i--){
            int total = 0;
            for(int j=n; j>=1; j--){
                total += dp[i][j];
            }
            if(total <= ans){
                ans = total;
                num = i;
            }
        }
        System.out.println(num);
    }
}
