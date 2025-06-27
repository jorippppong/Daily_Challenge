package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sumNearZero = Long.MAX_VALUE;
        int[] ans = new int[2];

        int lIdx = 0;
        int rIdx = n - 1;
        while (lIdx < rIdx) {
            int sum = arr[lIdx] + arr[rIdx];
            if (Math.abs(sum) < sumNearZero) {
                sumNearZero = Math.abs(sum);
                ans[0] = arr[lIdx];
                ans[1] = arr[rIdx];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                lIdx += 1;
            } else {
                rIdx -= 1;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
