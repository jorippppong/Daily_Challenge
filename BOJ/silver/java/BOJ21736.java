package boj.silver.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        int[] doyeon = new int[2];
        for(int i=0; i<row; i++){
            String line = br.readLine();
            arr[i] = line.toCharArray();
            for(int j=0; j<col; j++){
                if(arr[i][j] == 'I'){
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }

        // BFS
        int ans = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(doyeon);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1];
            if(arr[cx][cy] == 'X') continue;
            else if(arr[cx][cy] == 'P') ans++;
            arr[cx][cy] = 'X';

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && arr[nx][ny] != 'X'){
                    q.add(new int[]{nx, ny});
                }
            }
        }

        String result = ans == 0 ? "TT" : String.valueOf(ans);
        System.out.println(result);
    }
}
