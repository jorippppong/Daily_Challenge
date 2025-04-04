// https://www.acmicpc.net/problem/1865

package boj.gold.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1865 {
    static int n;
    static int m;
    static int w;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
    
        // 계산
        for(int i=0; i<tc; i++){
            List<Node> arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());   

            // 도로 입력 (양방향), 웜홀 입력 (단방향)
            for(int j=0; j<m+w; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if(j<m){
                    arr.add(new Node(s, e, cost));
                    arr.add(new Node(e, s, cost));
                }
                else{
                    arr.add(new Node(s, e, -cost));
                }
            }

            // 각 노드가 시간을 되돌릴수 있는지 확인
            boolean flag = false;
            for(int j=1; j<=n; j++){
                if(bellmanFord(arr, j)){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            
        }

    }

    // 밸만 포드 (시작지점으로 다시 돌아왔을 때 0보다 작은지 확인)
    static boolean bellmanFord(List<Node> arr, int start){
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        
        // n번 반복
        for(int i=0; i<n; i++){
            boolean update = false;
            for(Node node:arr){
                // 더 작은 값으로 갱신할 수 있을 때
                if(cost[node.start] != Integer.MAX_VALUE && cost[node.start]+ node.cost < cost[node.end]){
                    cost[node.end] = cost[node.start] + node.cost;
                    update = true;
                    if(i == n-1) return true;
                }
            }
            // 모든 간선을 반복했음에도 업데이트가 되지않는다면 이후에 굳이 실행할 필요 없음
            if(!update) break;
        }
        return false;
    }

    private static class Node{
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
