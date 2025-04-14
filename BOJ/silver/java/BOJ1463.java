package boj.silver.java;

import java.util.Scanner;

public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){
            int minNum = Integer.MAX_VALUE;
            if(i%3 == 0){
                minNum = Math.min(dp[i/3], minNum);
            }
            if(i%2 == 0){
                minNum = Math.min(dp[i/2], minNum);
            }
            minNum = Math.min(dp[i-1], minNum);
            
            dp[i] = minNum + 1;
        }
        System.out.println(dp[n]);
    }
}
