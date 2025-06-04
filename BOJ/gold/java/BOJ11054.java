package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = calInc();
        int[] dec = calDec();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, inc[i] + dec[i] + 1);
        }
        System.out.println(ans);
    }

    private static int[] calInc() {
        int[] inc = new int[n];
        for (int i = 1; i < n; i++) {
            int maxInc = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxInc = Math.max(maxInc, inc[j]);
                }
            }
            inc[i] = maxInc + 1;
        }
        return inc;
    }

    private static int[] calDec() {
        int[] dec = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int maxDec = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    maxDec = Math.max(maxDec, dec[j]);
                }
            }
            dec[i] = maxDec + 1;
        }
        return dec;
    }
}
