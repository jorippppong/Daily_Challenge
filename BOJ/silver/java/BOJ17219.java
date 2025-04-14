package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            String url = st.nextToken();
            String password = st.nextToken();
            map.put(url, password);
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            String url = br.readLine();
            String password = map.get(url);
            sb.append(password);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
