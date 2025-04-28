package boj.silver.java;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        int[] start = new int[2]; // '2'인 시작 위치
        int[][] ans = new int[row][col];
        for(int i=0; i<row; i++){
            Arrays.fill(ans[i], -1);
        }
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) start = new int[]{i, j};
                if(arr[i][j] == 0) ans[i][j] = 0;
            }
        }
        
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0}); // x, y, cost
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1], cost = curr[2];
            if(ans[cx][cy] != -1) continue; // 이미 방문 완료
            ans[cx][cy] = cost;

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && ans[nx][ny] != 0){
                    if(ans[nx][ny] == -1){
                        q.add(new int[]{nx, ny, cost+1});
                    }
                }
            }
        }
        

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                sb.append(ans[i][j])
                .append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}