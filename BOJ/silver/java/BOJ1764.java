package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> nSet = new HashSet<>();
        Set<String> bothSet = new TreeSet<>();
        while(n-- > 0){
            nSet.add(br.readLine());
        }
        while(m-- > 0){
            String name = br.readLine();
            if(nSet.contains(name)){
                bothSet.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bothSet.size()+"\n");
        for(String s : bothSet){
            sb.append(s+"\n");
        }
        System.out.println(sb.toString());
    }
}