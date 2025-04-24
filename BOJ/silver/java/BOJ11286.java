package boj.silver.java;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                if(Math.abs(a) == Math.abs(b)){
                    return a - b;
                }
                else{
                    return Math.abs(a) - Math.abs(b);
                }
            }
        );
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(x);
            }
        }
    }
}
