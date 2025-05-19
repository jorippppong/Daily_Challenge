package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 2; i++) {
                    if (j == 0) {
                        continue;
                    }
                    if (j == 1) {
                        arr[i][j] += arr[1 - i][j - 1];
                    } else {
                        arr[i][j] += Math.max(arr[1 - i][j - 1], arr[1 - i][j - 2]);
                    }
                }
            }
            System.out.println(Math.max(arr[0][n - 1], arr[1][n - 1]));
        }
    }
}
