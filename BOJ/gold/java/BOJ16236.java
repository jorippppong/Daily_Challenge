package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16236 {
    private static int n;
    private static int[][] arr;
    private static int[] shark; // {x, y}
    private static int sharkSize = 2;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new int[]{i, j};
                    arr[i][j] = 0;
                }
            }
        }

        int cnt = 0;
        int time = 0;
        while (true) {
            int[] fish = findFish();
            if (fish == null) {
                System.out.println(time);
                return;
            }

            time += fish[0];
            int cx = fish[1];
            int cy = fish[2];
            arr[cx][cy] = 0;
            shark[0] = cx;
            shark[1] = cy;
            cnt += 1;
            if (cnt == sharkSize) {
                sharkSize += 1;
                cnt = 0;
            }
        }
    }

    private static int[] findFish() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // {time, x, y}
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        boolean[][] visited = new boolean[n][n];
        visited[shark[0]][shark[1]] = true;
        pq.add(new int[]{0, shark[0], shark[1]});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int cx = curr[1];
            int cy = curr[2];
            if (arr[cx][cy] > 0 && arr[cx][cy] < sharkSize) {
                return curr;
            }
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    pq.add(new int[]{time + 1, nx, ny});
                }
            }
        }
        return null;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
