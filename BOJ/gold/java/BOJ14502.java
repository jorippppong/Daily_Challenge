package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {

    private static int row;
    private static int col;
    private static int[][] arr;
    private static int ans = -1;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final List<Integer> idxes = new ArrayList<>();
    private static final List<int[]> cands = new ArrayList<>();
    private static final List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    cands.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        comb();
        System.out.println(ans);
    }

    private static void comb() {
        if (idxes.size() == 3) {
            ans = Math.max(ans, calSafeArea());
            return;
        }
        int lastIdx = idxes.size() == 0 ? -1 : idxes.get(idxes.size() - 1);
        for (int i = lastIdx + 1; i < cands.size(); i++) {
            idxes.add(i);
            comb();
            idxes.remove(idxes.size() - 1);
        }
    }

    // 0 : 빈 칸, 1 : 벽, 2 : 바이러스
    private static int calSafeArea() {
        boolean[][] visited = new boolean[row][col];
        for (int idx : idxes) {
            int[] wall = cands.get(idx);
            arr[wall[0]][wall[1]] = 1;
        }

        Queue<int[]> q = new ArrayDeque<>(virus);
        while (!q.isEmpty()) {
            int[] v = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = v[0] + dx[k];
                int ny = v[1] + dy[k];
                if (inRange(nx, ny) && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    ans += 1;
                }
            }
        }

        for (int idx : idxes) {
            int[] wall = cands.get(idx);
            arr[wall[0]][wall[1]] = 0;
        }
        return ans;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
