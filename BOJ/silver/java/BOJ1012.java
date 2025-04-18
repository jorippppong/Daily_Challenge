package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int[][] arr = new int[row][col];
            Queue<int[]> q = new LinkedList<>();
            while(num-- > 0){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
                q.add(new int[]{x, y});
            }

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            int ans = 0;
            // BFS
            while(!q.isEmpty()){
                int[] cab = q.poll();
                int cx = cab[0];
                int cy = cab[1];
                if(arr[cx][cy] == 0){
                    continue;
                }

                Queue<int[]> close = new LinkedList<>();
                close.add(new int[]{cx, cy});
                while(!close.isEmpty()){
                    int[] one = close.poll();
                    if(arr[one[0]][one[1]] == 0){
                        continue;
                    }
                    
                    arr[one[0]][one[1]] = 0;
                    for(int i=0; i<4; i++){
                        int nx = one[0] + dx[i];
                        int ny = one[1] + dy[i];
                        if(nx >= 0 && nx < row && ny >= 0 && ny < col && arr[nx][ny] == 1){
                            close.add(new int[]{nx, ny});
                        }
                    }
                }
                ans++;
            }

            System.out.println(ans);
        }
    }

}