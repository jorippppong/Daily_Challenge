package boj.gold.java;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    private static int n;
    private static char[][] arr;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(countSection(false))
        .append(" ")
        .append(countSection(true));
        System.out.println(sb);
    }

    private static int countSection(boolean isColorBlind){        
        int ans = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    ans++;
                    bfs(visited, i, j, isColorBlind);
                }
            }
        }
        return ans;
    }

    private static void bfs(boolean[][] visited, int i, int j, boolean isColorBlind){
        char color = arr[i][j];

        Queue<int[]> q = new LinkedList<>(); // {x, y}
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1];
            if(visited[cx][cy]) continue;
            visited[cx][cy] = true;

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(inRange(nx, ny) && visited[nx][ny] == false && matchColor(color, arr[nx][ny], isColorBlind)){
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean matchColor(char color, char target, boolean isColorBlind){
        if(color == target) return true;
        if(isColorBlind){
            if((color == 'R' && target == 'G') || (color == 'G' && target == 'R')){
                return true;
            }
        }
        return false;
    }

}
