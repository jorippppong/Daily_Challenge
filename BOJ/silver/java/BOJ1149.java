// https://www.acmicpc.net/problem/1149

package silver.java;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] color = new int[n][3]; // 빨, 초, 파
        for(int i = 0; i<n; i++){
            for(int j =0; j<3; j++){
                color[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][3];
        for(int j =0; j<3; j++){
            dp[0][j] = color[0][j];
        }
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
        }


        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
        sc.close();
    }
}
