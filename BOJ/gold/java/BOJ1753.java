// https://www.acmicpc.net/problem/1753

package gold.java;

import java.util.*;

public class BOJ1753 {
    static int MAX_VALUE = Integer.MAX_VALUE;
    static ArrayList<Pair>[] arr;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        arr = new ArrayList[v+1];
        for(int i=0; i<v+1; i++){
            arr[i] = new ArrayList<Pair>();
        }
        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            arr[a].add(new Pair(cost, b));
        }

        int[] result = dijkstra(start, v);
        for(int i=1; i<v+1; i++){
            if(result[i] == MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(result[i]);
            }
        }

        sc.close();
    }

    static int[] dijkstra(int start, int v){
        int[] cost = new int[v+1];
        Arrays.fill(cost, MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> (p1.cost - p2.cost));
        queue.add(new Pair(0, start));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.cost > cost[p.node]){
                continue;
            }
            for(Pair path : arr[p.node]){
                if(p.cost + path.cost < cost[path.node]){
                    cost[path.node] = p.cost + path.cost;
                    queue.add(new Pair(cost[path.node], path.node));
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
