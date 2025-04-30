package boj.gold.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        Queue<int[]> q = new LinkedList<>(); // {x, y, day}
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.add(new int[]{i, j, 0});
                    arr[i][j] = 0;
                }
            }
        }

        if(q.size() == row * col){
            System.out.println(0);
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int date = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cDate = curr[2];
            if(arr[cx][cy] != 0) continue;
            arr[cx][cy] = 1;
            date = Math.max(date, cDate);

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && arr[nx][ny] == 0){
                    q.add(new int[]{nx, ny, cDate+1});
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(date);
    }
}
