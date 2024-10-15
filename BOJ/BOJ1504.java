// https://www.acmicpc.net/problem/1504

import java.util.*;

public class BOJ1504 {
    static int n;
    static int e;
    static int arr[][]; // 인접 배열 (0이면 경로 없음)
    static int MAX_VALUE = 200000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        arr = new int[n+1][n+1];
        for(int i=0; i<e; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            arr[x][y] = cost;
            arr[y][x] = cost;
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 1. 1~a~b~n
        // 2. 1~b~a~n
        int[] start1 = dijkstra(1);
        int aToB = dijkstra(a)[b];
        int[] startN = dijkstra(n);

        int min1 = start1[a] + aToB + startN[b];
        int min2 = start1[b] + aToB + startN[a];
        if(Math.min(min1, min2) >= MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(min1, min2));
        }
            
        sc.close();
    }

    static int[] dijkstra(int start){
        int cost[] = new int[n+1];
        Arrays.fill(cost, MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> (p1.cost - p2.cost));
        queue.add(new Pair(0, start));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.cost > cost[p.node]){
                continue;
            }
            for(int i=1; i<=n; i++){
                if(arr[p.node][i] != 0){
                    if(arr[p.node][i] + p.cost < cost[i]){
                        cost[i] = arr[p.node][i] + p.cost;
                        queue.add(new Pair(cost[i], i));
                    }
                }
            }
        }
        return cost;
    }

    static class Pair{
        int cost;
        int node;
    
        Pair(int cost, int node){
            this.cost = cost;
            this.node = node;
        }
    }
}
