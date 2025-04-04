package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
1. 아이디어 : 
map

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
map
*/

public class BOJ1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            String str = br.readLine();
            map.put(str, String.valueOf(i));
            map.put(String.valueOf(i), str);
        }

        for(int j=0; j<m; j++){
            String input = br.readLine();
            System.out.println(map.get(input));
        }
    }
}