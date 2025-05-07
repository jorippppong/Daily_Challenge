package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    private static int row;
    private static int col;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int ans = -1;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                solve(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);
    }

    // dfs
    private static void solve(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (inRange(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                solve(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;

                if (cnt == 2) {
                    visited[nx][ny] = true;
                    solve(x, y, cnt + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
