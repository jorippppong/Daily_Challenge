package boj.silver.java;

import java.io.*;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[len];
        int ans = 0;
        for(int i=0; i<len; i++){
            if(arr[i] == 'I'){
                if(i == 0){
                    dp[i] = 1;
                    continue;
                }
                if(arr[i-1] != arr[i]) dp[i] = dp[i-1] + 1;
                else{
                    ans += cal(n, dp[i-1]);
                    dp[i] = 1;
                }
            }
            else{
                if(i == 0) continue;
                if(arr[i-1] != arr[i]) dp[i] = dp[i-1] + 1;
                else ans += cal(n, dp[i-1]);
            }
        }
        ans += cal(n, dp[len-1]);
        System.out.println(ans);
    }

    // len : I부터 시작한 길이
    private static int cal(int n, int len){
        if(len % 2 == 0) len -= 1;
        int zeroCnt = len / 2;
        if(zeroCnt < n) return 0;
        return 1 + (zeroCnt - n);
    }
}
