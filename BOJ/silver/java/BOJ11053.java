// https://www.acmicpc.net/problem/11053

package boj.silver.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            int maxLen = 0;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen + 1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());   
    }
}
