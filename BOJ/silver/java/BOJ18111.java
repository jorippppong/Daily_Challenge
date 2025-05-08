package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    private static int b;
    private static int len;
    private static int[] arr;
    private static int minSec = Integer.MAX_VALUE;
    private static int ansHeight = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        len = n * m;
        arr = new int[len];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i * m + j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int height = 0; height <= 256; height++) {
            int sec = calculate(height);
            if (sec == -1) continue;
            if (sec == minSec) {
                ansHeight = Math.max(ansHeight, height);
            } else if (sec < minSec) {
                minSec = sec;
                ansHeight = height;
            }
        }
        System.out.println(minSec + " " + ansHeight);
    }

    // 불가능하면 -1
    private static int calculate(int height) {
        int block = b;
        int sec = 0;
        for (int i = 0; i < len; i++) {
            int diff = arr[i] - height;
            block += diff;
            sec += (diff >= 0 ? diff * 2 : Math.abs(diff));
        }
        return block >= 0 ? sec : -1;
    }
}
