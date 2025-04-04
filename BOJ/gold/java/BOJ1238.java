// https://www.acmicpc.net/problem/1238

package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static int n;
    static int arr[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 학생
        int m = Integer.parseInt(st.nextToken()); // 경로 갯수
        int x = Integer.parseInt(st.nextToken()); // 목적지
        
        arr = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end] = cost;
        }

        // 집 -> x
        int[] toX = new int[n+1];
        for(int i=1; i<n+1; i++){
            toX[i] = dijkstra(i)[x];
        }

        // x -> 집 (다익스트라)
        int[] toHome = dijkstra(x);

        // 가장 시간 오래 소요되는 학생 찾기
        int answer = -1;
        for(int i=1; i<n+1; i++){
            answer = Math.max(answer, toX[i]+toHome[i]);
        }
        System.out.println(answer);
    }

    // 최단 거리
    private static int[] dijkstra(int start){
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((q1, q2) -> (q1.cost - q2.cost));  // 거리를 기준으로 오름차순 정렬
        q.add(new Pair(start, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(cost[p.x] < p.cost) continue;
            for(int i=1; i<n+1; i++){
                if(arr[p.x][i] == 0) continue;
                if(p.cost + arr[p.x][i] < cost[i]){
                    q.add(new Pair(i, p.cost + arr[p.x][i]));
                    cost[i] = p.cost + arr[p.x][i];
                }
            }
        }

        return cost;
    }

    private static class Pair{
        int x;
        int cost;

        Pair(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }


}
