// https://www.acmicpc.net/problem/1932

package silver.java;

import java.util.Scanner;

public class BOJ1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int j=0; j<n; j++){
            dp[n-1][j] = arr[n-1][j];
        }
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }

        System.out.println(dp[0][0]);

        sc.close();
    }
}