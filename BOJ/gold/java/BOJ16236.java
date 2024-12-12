// https://www.acmicpc.net/problem/16236

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16236 {
    static int n;
    static int[][] arr;
    static int size = 2;
    static int cnt = 0;
    static int time = 0;

    static int currX;
    static int currY;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    arr[i][j] = 0;
                    currX = i;
                    currY = j;
                }
            }
        }

        // simulate
        while(true){
            Fish f = bfs();

            // 먹을 수 있는 물고기가 없을 때
            if(f == null) break;

            // 먹을 수 있는 물고기가 있을 때
            time += f.len;
            arr[f.x][f.y] = 0;
            currX = f.x; currY = f.y;
            cnt++;
            if(cnt == size){
                size++;
                cnt = 0;
            }
        }
        System.out.println(time);
    }

    // return null; 이면 먹을게 없다는 뜻
    static Fish bfs(){
        // 최단 거리, 위, 왼쪽
        PriorityQueue<Fish> queue = new PriorityQueue<>((f1, f2) -> {
            if(f1.len == f2.len){
                if(f1.x == f2.x){
                    return f1.y - f2.y;
                }
                return f1.x - f2.x;
            }
            return f1.len - f2.len;
        });
        boolean[][] visited = new boolean[n][n];

        // BFS
        queue.add(new Fish(0, currX, currY));
        visited[currX][currY] = true;
        while(!queue.isEmpty()){
            Fish f = queue.poll();
            if(arr[f.x][f.y] > 0 && arr[f.x][f.y] < size){
                return f;
            }
            for(int i=0; i<4; i++){
                int nx = f.x + dx[i];
                int ny = f.y + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] <= size){
                    visited[nx][ny] = true;
                    queue.add(new Fish(f.len+1, nx, ny));
                }
            }
        }
        return null;
    }

    static boolean inRange(int x, int y){
        return x>=0 && x<n && y>= 0 && y<n;
    }

    private static class Fish {
        int len; // 거리
        int x;
        int y;

        Fish(int len, int x, int y){
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
