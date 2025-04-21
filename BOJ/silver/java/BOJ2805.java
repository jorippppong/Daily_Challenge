package boj.silver.java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n+1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        

        Arrays.sort(arr, (a, b) -> b - a);
        int total = arr[0];
        int idx = 1;
        outer: while(true){
            for(int num = arr[idx-1] -1; num>=arr[idx]; num--){
                if(total - (num * idx) >= h){
                    System.out.println(num);
                    break outer;
                }
            }

            total += arr[idx];
            idx++;
        }
    }
}
