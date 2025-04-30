package boj.gold.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[height][row][col];
        Queue<int[]> q = new LinkedList<>(); // {x, y, z, day}
        for(int h=0; h<height; h++){
            for(int i=0; i<row; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<col; j++){
                    arr[h][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[h][i][j] == 1){
                        q.add(new int[]{i, j, h, 0});
                        arr[h][i][j] = 0;
                    }
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
        if(q.size() == height*row*col){
            System.out.println(0);
            return;
        }

        int date = 0;
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cz = curr[2];
            int cDate = curr[3];
            if(arr[cz][cx][cy] != 0) continue;
            arr[cz][cx][cy] = 1;
            date = Math.max(date, cDate);

            for(int k=0; k<6; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                int nz = cz + dz[k];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && nz >= 0 && nz < height && arr[nz][nx][ny] == 0){
                    q.add(new int[]{nx, ny, nz, cDate+1});
                }
            }
        }

        // 토마토가 모두 익지는 못하는 상황이면 -1을 출력
        for(int h=0; h<height; h++){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(arr[h][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(date);
    }
}
