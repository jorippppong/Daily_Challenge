package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // bfs
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[row][col][2];
        q.add(new int[]{0, 0, 1, 0}); // {x, y, cost, 벽 뚫었음(1)/벽 뚫지 않음(0)}
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int dist = curr[2];
            int broken = curr[3];
            if (cx == row - 1 && cy == col - 1) {
                System.out.println(dist);
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (arr[nx][ny] == '0' && !visited[nx][ny][broken]) {
                        q.add(new int[]{nx, ny, dist + 1, broken});
                        visited[nx][ny][broken] = true;
                    }
                    if (arr[nx][ny] == '1' && broken == 0 && !visited[nx][ny][1]) {
                        q.add(new int[]{nx, ny, dist + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
