package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                int minNum = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(minNum);
            }
            else{
                pq.add(x);
            }
        }
    }
}
