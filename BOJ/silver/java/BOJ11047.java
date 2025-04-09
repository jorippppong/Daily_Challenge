package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coin = new ArrayList<>();
        while(n-- > 0){
            coin.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(coin, Collections.reverseOrder());

        int ans = 0;
        for(int i=0; i<coin.size(); i++){
            ans += (k / coin.get(i));
            k %= coin.get(i);
        }
        System.out.println(ans);
    }
}