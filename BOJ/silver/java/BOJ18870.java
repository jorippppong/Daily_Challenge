package boj.silver.java;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);
        int[] accum = new int[n];
        for(int i=1; i<n; i++){
            if(sortArr[i] > sortArr[i-1]){
                accum[i] = accum[i-1] + 1;
            }
            else{
                accum[i] = accum[i-1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(sortArr[i], accum[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(map.get(arr[i]));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
