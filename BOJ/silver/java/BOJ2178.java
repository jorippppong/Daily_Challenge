package boj.silver.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        for(int i=0; i<row; i++){
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        // bfs
        Queue<int[]> q = new LinkedList<>(); // {x, y, cost}
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1], cost = curr[2];
            if(cx == row-1 && cy == col-1){
                System.out.println(cost);
                return;
            }
            if(arr[cx][cy] == '0') continue;
            arr[cx][cy] = '0';

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && arr[nx][ny] == '1'){
                    q.add(new int[]{nx, ny, cost+1});
                }
            }
        }
    }
}