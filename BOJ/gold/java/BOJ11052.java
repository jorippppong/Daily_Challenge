// https://www.acmicpc.net/problem/11054

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        // 증가 DP
        int[] inc = new int[n];
        inc[0] = 1;
        for(int i=1; i<n; i++){
            int maxValue = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i] && inc[j] > maxValue){
                    maxValue = inc[j];
                }
            }
            inc[i] = maxValue + 1;
        }

        // 감소 DP
        int[] dec = new int[n];
        dec[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            int maxValue = 0;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[i] && dec[j] > maxValue){
                    maxValue = dec[j];
                }
            }
            dec[i] = maxValue + 1;
        }

        // 가장 긴 바이토닉 수열
        int maxValue = 0;
        for(int i=0; i<n; i++){
            maxValue = Math.max(maxValue, inc[i]+dec[i]-1);
        }
        System.out.println(maxValue);
    }

    
}
