package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            while(n-- > 0){
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                int remain = clothes.getOrDefault(type, 0);
                clothes.put(type, remain+1);
            }

            int ans = 1;
            for(String type : clothes.keySet()){
                ans *= (clothes.get(type)+1);
            }
            System.out.println(ans - 1);
        }
    }
}