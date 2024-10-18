// https://www.acmicpc.net/problem/1967

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {
    static int n;
    static ArrayList<Pair>[] arr;
    static boolean[] visited;
    static int result = 0;

    // 가능한 모든 경로를 탐색 (DFS)
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<Pair>();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 양방향
            arr[a].add(new Pair(b, cost));
            arr[b].add(new Pair(a, cost));
        }

        for(int i=1; i<n+1; i++){
            Arrays.fill(visited, false);
            visited[i] = true;
            DFS(i, 0);
        }
        System.out.println(result);
    }

    static void DFS(int node, int cost){
        for(Pair p:arr[node]){
            if(visited[p.child] != true){
                visited[p.child] = true;
                DFS(p.child, cost+p.cost);
            }
        }
        result = Math.max(cost, result);
    }

    static class Pair{
        int child;
        int cost;
    
        Pair(int child, int cost){
            this.child = child;
            this.cost = cost;
        }
    }
}
