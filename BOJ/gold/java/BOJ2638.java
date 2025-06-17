package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
    private static int row;
    private static int col;
    private static int[][] arr;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // bfs (공기 확인)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        int totalCheese = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    totalCheese += 1;
                }
            }
        }

        int hour = 0;
        while (totalCheese > 0) {
            boolean[][] air = airInAndOut();
            // 치즈 삭제 로직
            int deleteCheese = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == 0) {
                        continue;
                    }

                    int pollutedAir = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (inRange(nx, ny) && air[nx][ny]) {
                            pollutedAir += 1;
                        }
                    }
                    if (pollutedAir >= 2) {
                        arr[i][j] = 0;
                        deleteCheese += 1;
                    }
                }
            }

            totalCheese -= deleteCheese;
            hour += 1;
        }
        System.out.println(hour);
    }

    // 외부 , 내부 공기 구분 (true = 외부 감염 공기)
    // 치즈는 무조건 false
    private static boolean[][] airInAndOut() {
        boolean[][] air = new boolean[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            air[i][0] = true;
            visited[i][0] = true;
            q.add(new int[]{i, 0});
            air[i][col - 1] = true;
            visited[i][col - 1] = true;
            q.add(new int[]{i, col - 1});
        }
        for (int j = 1; j < col - 1; j++) {
            air[0][j] = true;
            visited[0][j] = true;
            q.add(new int[]{0, j});
            air[row - 1][j] = true;
            visited[row - 1][j] = true;
            q.add(new int[]{row - 1, j});
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                if (inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 0) {
                    air[nx][ny] = true;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return air;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
