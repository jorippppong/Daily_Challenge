package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxNum = -1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, arr[i]);
        }

        // 이진 탐색
        long start = 1;
        long end = maxNum;
        long ans = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < k) {
                end = mid - 1;
            } else {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
