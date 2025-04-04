// https://www.acmicpc.net/problem/12851

package boj.gold.java;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ12851 {
    static int time = 0;
    static boolean updated = false;
    static boolean[] visited;
    static int way = 0;

    public static void main(String[] args) {
        // -1, +1, 순간이동 하면 2*x
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        visited = new boolean[100000 * 2];

        bfs(n, k);
        System.out.println(time);
        System.out.println(way);

        sc.close();
    }

    private static void bfs(int n, int k){
        LinkedList<Path> queue = new LinkedList<>();
        queue.addLast(new Path(0, n));

        while(!queue.isEmpty()){
            Path p = queue.pollFirst();
            // time이 같은 경우 경로+1 을 해야하기 때문에 poll 할때 true로 설정 
            // addLast 할때 true 설정하면 k에 도달했을 때 경로가 추가 안되는 경우가 발생할 수 있다.
            visited[p.location] = true;  
            if(time != 0 && p.time > time){
                return;
            }

            if(p.location == k){
                // 최단 시간 업데이트
                if(updated == false){
                    time = p.time;
                    way += 1;
                    updated = true;
                }
                else{
                    // 가장 빠른 시간 경로 추가
                    if(p.time == time){
                        way += 1;
                    }
                }
                continue;
            }

            // 경로 삽입
            if(p.location*2 >= 0 && p.location*2 <= 100000 && visited[p.location*2] == false){
                queue.addLast(new Path(p.time+1, p.location*2));
            }
            if(p.location-1 >= 0 && p.location-1 <= 100000 && visited[p.location-1] == false){
                queue.addLast(new Path(p.time+1, p.location-1));
            }
            if(p.location+1 >= 0 && p.location+1 <= 100000 && visited[p.location+1] == false){
                queue.addLast(new Path(p.time+1, p.location+1));
            }
        }
    }

    private static class Path{
        int time;
        int location;

        Path(int time, int location){
            this.time = time;
            this.location = location;
        }
    }

}
