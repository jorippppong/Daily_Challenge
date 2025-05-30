package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {
    private static int n;
    private static byte[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new byte[n][2 * n - 1];  // 1 = *

        cal(0, n - 1, n);
        printStar();
    }

    private static void cal(int x, int y, int height) {
        if (height == 3) {
            arr[x][y] = 1;
            arr[x + 1][y - 1] = 1;
            arr[x + 1][y + 1] = 1;
            for (int i = y - 2; i <= y + 2; i++) {
                arr[x + 2][i] = 1;
            }
            return;
        }

        height /= 2;
        cal(x, y, height);
        cal(x + height, y - height, height);
        cal(x + height, y + height, height);
    }

    private static void printStar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (arr[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
