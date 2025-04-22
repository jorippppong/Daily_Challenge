package boj.silver.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = -1;
        int r = 0;
        for(int l=0; l<n; l++){
            map.put(arr[l], map.getOrDefault(arr[l], 0) + 1);
            if(map.size() <= 2) maxLen = Math.max(maxLen, l - r + 1);
            while(r < l && map.size() > 2){
                if(map.get(arr[r]) == 1){
                    map.remove(arr[r]);
                }
                else{
                    map.put(arr[r], map.get(arr[r]) - 1);
                }
                r++;
            }
        }
        System.out.println(maxLen);
    }

}
