package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP (최소 비용 저장)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int minNum = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        minNum = Math.min(minNum, arr[i - 1][k]);
                    }
                }
                arr[i][j] += minNum;
            }
        }
        System.out.println(Arrays.stream(arr[n - 1]).min().getAsInt());
    }
}
