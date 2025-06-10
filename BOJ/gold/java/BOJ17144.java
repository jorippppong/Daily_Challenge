package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {
    private static int row;
    private static int col;
    private static int machine; // 기계 아래 부분
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    machine = i;
                }
            }
        }

        // 공기 청정기
        while (time-- > 0) {
            spread(arr);
            circularUpper(arr);
            circularLower(arr);
        }

        // 결과 출력
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += arr[i][j];
            }
        }
        System.out.println(ans + 2);
    }

    private static void spread(int[][] arr) {
        int[][] accum = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }

                int dust = arr[i][j] / 5;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (inRange(nx, ny) && arr[nx][ny] != -1) {
                        accum[i][j] -= dust;
                        accum[nx][ny] += dust;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] += accum[i][j];
            }
        }
    }

    private static void circularUpper(int[][] arr) {
        int mx = machine - 1;
        for (int i = mx - 2; i >= 0; i--) {
            arr[i + 1][0] = arr[i][0];
        }
        for (int j = 1; j < col; j++) {
            arr[0][j - 1] = arr[0][j];
        }
        for (int i = 1; i <= mx; i++) {
            arr[i - 1][col - 1] = arr[i][col - 1];
        }
        for (int j = col - 2; j >= 1; j--) {
            arr[mx][j + 1] = arr[mx][j];
        }
        arr[mx][1] = 0;
    }

    private static void circularLower(int[][] arr) {
        int mx = machine;
        for (int i = mx + 2; i < row; i++) {
            arr[i - 1][0] = arr[i][0];
        }
        for (int j = 1; j < col; j++) {
            arr[row - 1][j - 1] = arr[row - 1][j];
        }
        for (int i = row - 2; i >= mx; i--) {
            arr[i + 1][col - 1] = arr[i][col - 1];
        }
        for (int j = col - 2; j >= 1; j--) {
            arr[mx][j + 1] = arr[mx][j];
        }
        arr[mx][1] = 0;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
