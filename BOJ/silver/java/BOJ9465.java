// https://www.acmicpc.net/problem/9465

package boj.silver.java;

import java.util.Scanner;

public class BOJ9465 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int test = sc.nextInt();
        
        for(int i=0; i<test; i++){
            int n = sc.nextInt();
            DP(n);
        }
    }

    static void DP(int n){
        int[][] arr = new int[2][n];
        for(int i =0; i<2; i++){
            for(int j =0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[2][n];
        int[] maxNum = new int[n];
        for(int j=0; j<n; j++){
            for(int i=0; i<2; i++){
                if(j==0){
                    dp[0][0] = arr[0][0];
                    dp[1][0] = arr[1][0];
                }
                else if(j==1){
                    dp[i][j] = dp[1-i][j-1] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.max(maxNum[j-2], dp[1-i][j-1]) + arr[i][j];
                }
            }
            maxNum[j] = Math.max(dp[0][j], dp[1][j]);
        }

        System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
    }
}
