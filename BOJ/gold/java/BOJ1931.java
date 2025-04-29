package boj.gold.java;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }); // {start, end},  회의가 먼저 끝나는거 기준으로 정렬

        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new int[]{s, e});
        }
        
        int end = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int s = top[0], e = top[1];
            if(s < end){
                continue;
            }
            end = e;
            ans += 1;
        }
        System.out.println(ans);
    }
}
